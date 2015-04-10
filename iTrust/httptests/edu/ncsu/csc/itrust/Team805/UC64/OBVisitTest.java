package edu.ncsu.csc.itrust.Team805.UC64;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebResponse;

import edu.ncsu.csc.itrust.http.iTrustHTTPTest;

/**
 * Use Case 64
 */
public class OBVisitTest extends iTrustHTTPTest {
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		HttpUnitOptions.setScriptingEnabled(false);
		gen.clearAllTables();
		gen.standardData();
	}
	
	public void testAddVisit() throws Exception {
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		wr = wr.getLinkWith("Obstetrics Patient Initialization").click();
		
		// Select Patient
		WebForm wf = wr.getFormWithID("mainForm");
		wf.getScriptableObject().setParameterValue("UID_PATIENTID", "5");
		wr = wf.submit();
		
		// Click Add Button
		
		WebLink addButton = wr.getMatchingLinks(WebLink.MATCH_URL_STRING, "Add")[2];
		wr = addButton.click();
		
		// Submit Visit Form
		WebForm addVisitForm = wr.getForms()[0];
		addVisitForm.getScriptableObject().setParameterValue("numWeeksPregVisit", "1");
		addVisitForm.getScriptableObject().setParameterValue("numPounds", "2");
		addVisitForm.getScriptableObject().setParameterValue("bloodPressure", "3");
		addVisitForm.getScriptableObject().setParameterValue("heartRate", "4");
		addVisitForm.getScriptableObject().setParameterValue("fundalHeight", "5");
		addVisitForm.submit();
		
		// Click link that was just added
		wr = wr.getLinkWith("Obstetrics Patient Initialization").click();
		Calendar today = Calendar.getInstance(); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(today.getTime());
		WebLink visitLink = wr.getLinkWith(currentDate);
		wr = visitLink.click();
		
		WebForm updateVisitForm = wr.getForms()[0];
		assertEquals(updateVisitForm.getParameterValue("numWeeksPregVisit"), "1");
		assertEquals(updateVisitForm.getParameterValue("numPounds"), "2.0");
		assertEquals(updateVisitForm.getParameterValue("bloodPressure"), "3");
		assertEquals(updateVisitForm.getParameterValue("heartRate"), "4");
		assertEquals(updateVisitForm.getParameterValue("fundalHeight"), "5.0");
		
	}
	
	public void testUpdateVisit() throws Exception {
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		wr = wr.getLinkWith("Obstetrics Patient Initialization").click();
		
		// Select Patient
		WebForm wf = wr.getFormWithID("mainForm");
		wf.getScriptableObject().setParameterValue("UID_PATIENTID", "5");
		wr = wf.submit();
		
		
		WebLink visitLink = wr.getLinkWith("2005-04-30");
		wr = visitLink.click();
		
		// Update values
		WebForm addVisitForm = wr.getForms()[0];
		addVisitForm.getScriptableObject().setParameterValue("numWeeksPregVisit", "5");
		addVisitForm.getScriptableObject().setParameterValue("numPounds", "4");
		addVisitForm.getScriptableObject().setParameterValue("bloodPressure", "3");
		addVisitForm.getScriptableObject().setParameterValue("heartRate", "2");
		addVisitForm.getScriptableObject().setParameterValue("fundalHeight", "1");
		addVisitForm.submit();
		
		wr = visitLink.click();
		WebForm updateVisitForm = wr.getForms()[0];
		assertEquals(updateVisitForm.getParameterValue("numWeeksPregVisit"), "5");
		assertEquals(updateVisitForm.getParameterValue("numPounds"), "4.0");
		assertEquals(updateVisitForm.getParameterValue("bloodPressure"), "3");
		assertEquals(updateVisitForm.getParameterValue("heartRate"), "2");
		assertEquals(updateVisitForm.getParameterValue("fundalHeight"), "1.0");
	}
	
	public void testLMPOver49Weeks() throws Exception {
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		wr = wr.getLinkWith("Obstetrics Patient Initialization").click();
		
		// Select Patient
		WebForm wf = wr.getFormWithID("mainForm");
		wf.getScriptableObject().setParameterValue("UID_PATIENTID", "55");
		wr = wf.submit();
		
		assertTrue(wr.getText().contains("LMP is greater than 49 weeks"));
	}


}
