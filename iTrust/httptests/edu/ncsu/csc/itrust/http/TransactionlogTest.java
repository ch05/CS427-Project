package edu.ncsu.csc.itrust.http;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class TransactionlogTest extends iTrustHTTPTest{
	
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		HttpUnitOptions.setExceptionsThrownOnScriptError(false);		
		gen.clearAllTables();
		gen.standardData();
	}

	public void testAdminTestRole1() throws Exception{
		//log in as Admin
		WebConversation wc = login("9000000001", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		assertEquals("iTrust - Admin Home", wr.getTitle());
		
		wr = wr.getLinkWith("Transaction Log").click();
		assertTrue(wr.getText().contains("Transaction Code Reference"));//Make sure we are on the correct page
		
		//fill in the form and submit
		WebForm transLog = wr.getForms()[0];
		transLog.setParameter("role1", "PATIENT");			
		transLog.submit();
		
		wr = wc.getCurrentPage();//update the page

		//Check the column entries
		assertTrue(wr.getText().contains("Type"));
		assertTrue(wr.getText().contains("Code"));
		assertTrue(wr.getText().contains("Description"));

		//Check the first few rows
		assertTrue(wr.getText().contains("LOGIN_FAILURE"));
		assertTrue(wr.getText().contains("1"));
		assertTrue(wr.getText().contains("Failed login"));

		//Check the last few rows
		assertTrue(wr.getText().contains("FEATURE_DISABLED"));
		assertTrue(wr.getText().contains("6104"));
	}
	
	public void testTesterTestRol2() throws Exception {
		WebConversation wc = login("9999999999", "pw");//log in as tester
		WebResponse wr = wc.getCurrentPage();
		
		assertEquals("iTrust - Tester Home", wr.getTitle());
		
		wr = wr.getLinkWith("Transaction Log").click();
		assertTrue(wr.getText().contains("Transaction Code Reference"));
		
		//fill in the form and submit
		WebForm transLog = wr.getForms()[0];
		transLog.setParameter("role2", "HCP");			
		transLog.submit();
		
		wr = wc.getCurrentPage();//update the page

		//Check the column entries
		assertTrue(wr.getText().contains("Type"));
		assertTrue(wr.getText().contains("Code"));
		assertTrue(wr.getText().contains("Description"));

		//Check the first few rows
		assertTrue(wr.getText().contains("HOME_VIEW"));
		assertTrue(wr.getText().contains("10"));
		assertTrue(wr.getText().contains("User views homepage"));

		assertTrue(wr.getText().contains("UNCAUGHT_EXCEPTION"));
		assertTrue(wr.getText().contains("20"));
		assertTrue(wr.getText().contains("Exception occured and was not caught"));
	}
	
}
	
	
	
