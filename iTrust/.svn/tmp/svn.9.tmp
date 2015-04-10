package edu.ncsu.csc.itrust.Team805.UC39;

import org.junit.Before;
import org.junit.Test;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

import edu.ncsu.csc.itrust.http.iTrustHTTPTest;
import edu.ncsu.csc.itrust.DBBuilder;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.enums.TransactionType;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

@SuppressWarnings("unused")
public class TransactionlogTest extends iTrustHTTPTest{
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		HttpUnitOptions.setExceptionsThrownOnScriptError(false);	
		HttpUnitOptions.setScriptingEnabled(false);
		gen.clearAllTables();
		gen.standardData();
	}
	@Test
	
	public void testTesterRole1HCP() throws Exception{
		//log in as tester
		WebConversation wc = login("9999999999", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - Tester Home", wr.getTitle());
			
		wr = wr.getLinkWith("Transaction Log").click();
		assertEquals("iTrust - Transaction Log", wr.getTitle());
	
		// fill in the form and submit
		WebForm transLog = wr.getForms()[0];
		transLog.setParameter("role1", "HCP");
		transLog.getSubmitButtons()[0].click();
			
		wr = wc.getCurrentPage();//update the page
		
		WebTable table = wr.getTables()[1];
		
		assertTrue(table.getRows()[1].getText().contains("HCP"));
		assertTrue(table.getRows()[1].getText().contains("PATIENT"));
		assertTrue(table.getRows()[1].getText().contains("PATIENT_LIST_ADD"));
		assertTrue(table.getRows()[1].getText().contains("2011-06-24 06:54:59.0"));
	
		assertTrue(table.getRows()[4].getText().contains("HCP"));
		assertTrue(table.getRows()[4].getText().contains("PATIENT"));
		assertTrue(table.getRows()[4].getText().contains("OFFICE_VISIT_EDIT"));
		assertTrue(table.getRows()[4].getText().contains("2008-12-01 11:30:00.0"));
		
		assertTrue(table.getRows()[7].getText().contains("HCP"));
		assertTrue(table.getRows()[7].getText().contains("PATIENT"));
		assertTrue(table.getRows()[7].getText().contains("PRESCRIPTION_REPORT_VIEW"));
		assertTrue(table.getRows()[7].getText().contains("2008-07-15 13:13:00.0"));
		
		assertTrue(table.getRows()[9].getText().contains("HCP"));
		assertTrue(table.getRows()[9].getText().contains("PATIENT"));
		assertTrue(table.getRows()[9].getText().contains("RISK_FACTOR_VIEW"));
		assertTrue(table.getRows()[9].getText().contains("2008-06-15 13:15:00.0"));
	}
	
	@Test
	public void testTesterRole1ER() throws Exception{
		//log in as tester
		WebConversation wc = login("9999999999", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - Tester Home", wr.getTitle());
		
		wr = wr.getLinkWith("Transaction Log").click();
		assertEquals("iTrust - Transaction Log", wr.getTitle());

		//fill in the form and submit
		WebForm transLog = wr.getForms()[0];
		transLog.setParameter("role1", "ER");
		transLog.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();//update the page

		WebTable table = wr.getTables()[1];
		assertTrue(table.getRows()[1].getText().contains("ER"));
		assertTrue(table.getRows()[1].getText().contains("PATIENT"));
		assertTrue(table.getRows()[1].getText().contains("EMERGENCY_REPORT_VIEW"));
		assertTrue(table.getRows()[1].getText().contains("2008-11-14 10:04:00.0"));
		
		assertTrue(table.getRows()[2].getText().contains("ER"));
		assertTrue(table.getRows()[2].getText().contains("PATIENT"));
		assertTrue(table.getRows()[2].getText().contains("EMERGENCY_REPORT_VIEW"));
		assertTrue(table.getRows()[2].getText().contains("2008-11-14 09:32:00.0"));
	}
	
	@Test
	public void testTesterRole2Patient() throws Exception{
		//log in as tester
		WebConversation wc = login("9999999999", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertEquals("iTrust - Tester Home", wr.getTitle());
		
		wr = wr.getLinkWith("Transaction Log").click();
		assertEquals("iTrust - Transaction Log", wr.getTitle());

		//fill in the form and submit
		WebForm transLog = wr.getForms()[0];
		transLog.setParameter("role2", "PATIENT");
		transLog.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();//update the page

		WebTable table = wr.getTables()[1];
		for (int i = 1; i < table.getRowCount(); i++){
			assertTrue(table.getRows()[i].getText().contains("PATIENT"));
		}
	}

}