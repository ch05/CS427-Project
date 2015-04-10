package edu.ncsu.csc.itrust.Team805.UC30;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

import edu.ncsu.csc.itrust.DBBuilder;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.enums.TransactionType;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

/**
 * Use Case 30
 */
@SuppressWarnings("unused")
public class MessagingFilterTest extends iTrustHTTPTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp(); // clear tables is called in super
		HttpUnitOptions.setScriptingEnabled(false);
		gen.clearAllTables();
		gen.standardData();
	}	
	
	public void testpatientTestApplyMessageFilter() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase4.sql");
		
		// Login
		WebConversation wc = login("2", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 2L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 2L, 0L, "");
		wr = wr.getLinkWith("Apply Filter").click();
		
		// Make sure the proper message exists in the right order
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("Kelly Doctor"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("RE: Influenza Vaccine"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("2010-03-25 16:39"));

		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("Kelly Doctor"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("RE: Vaccines"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("2010-01-21 20:22"));
		
}
	
	public void testHCPtestApplyMessageFilter() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase1.sql");
		
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Apply Filter").click();
				
		// Make sure the proper message exists in the right order
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("Scratchy Throat"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("2010-02-02 13:03"));
		
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("Prescription"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("2010-01-31 12:12"));
		
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("RE: Lab Procedure"));
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("2010-01-29 17:58"));
		
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("Office Visit"));
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("2010-01-29 08:01"));
		
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("Appointment"));
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("2010-01-19 07:58"));
		
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("Lab Results"));
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("2010-01-13 13:46"));
	
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("Baby Programmer"));
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("Remote Monitoring Question"));
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("2010-01-07 09:15"));
	}
			
	public void testpatientTestEditMessageFilter() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase3.sql");
		
		// Login
		WebConversation wc = login("2", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 2L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 2L, 0L, "");
		wr = wr.getLinkWith("Edit Filter").click();
		
		// Enter filter information where has words is influenza
		wr.getForms()[0].setParameter("sender", "");
		wr.getForms()[0].setParameter("subject", "");
		wr.getForms()[0].setParameter("hasWords", "");
		wr.getForms()[0].setParameter("startDate", "04/08/2010");
		wr.getForms()[0].setParameter("notWords", "");
		wr.getForms()[0].setParameter("endDate", "04/07/2010");
		wr = wr.getForms()[0].submit(wr.getForms()[0].getSubmitButton("test"));
		
		// Make sure error message is displayed
		assertTrue(wr.getText().contains("Error: The end date cannot be before the start date."));	
	}
				
	public void testHCPtestEditMessageFilter() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase3.sql");
		
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Edit Filter").click();
		
		// Enter filter information where has words is influenza
		wr.getForms()[0].setParameter("sender", "");
		wr.getForms()[0].setParameter("subject", "");
		wr.getForms()[0].setParameter("hasWords", "influenza");
		wr.getForms()[0].setParameter("startDate", "");
		wr.getForms()[0].setParameter("notWords", "");
		wr.getForms()[0].setParameter("endDate", "");
		wr = wr.getForms()[0].submit(wr.getForms()[0].getSubmitButton("test"));
		
		// Make sure the proper message exists in the right order
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("RE: Influenza Vaccine"));
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("2010-03-25 16:30"));
		
		assertTrue(wr.getTables()[2].getRows()[2].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[2].getRows()[2].getText().contains("Influenza Vaccine"));
		assertTrue(wr.getTables()[2].getRows()[2].getText().contains("2010-03-25 16:15"));
		
		assertTrue(wr.getTables()[2].getRows()[3].getText().contains("Random Person"));
		assertTrue(wr.getTables()[2].getRows()[3].getText().contains("Flu Season"));
		assertTrue(wr.getTables()[2].getRows()[3].getText().contains("2009-12-03 08:26"));
		
		assertTrue(wr.getTables()[2].getRows()[4].getText().contains("Baby Programmer"));
		assertTrue(wr.getTables()[2].getRows()[4].getText().contains("Bad cough"));
		assertTrue(wr.getTables()[2].getRows()[4].getText().contains("2008-06-02 20:46"));	
	}

	public void testHCPtestCancelMessageFilter() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase1.sql");
		
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 9000000000L, 0L, "");
		wr = wr.getLinkWith("Edit Filter").click();
		
		// Enter filter information where has words is influenza
		wr.getForms()[0].setParameter("sender", "Andy Programmer");
		wr.getForms()[0].setParameter("subject", "");
		wr.getForms()[0].setParameter("hasWords", "");
		wr.getForms()[0].setParameter("startDate", "");
		wr.getForms()[0].setParameter("notWords", "");
		wr.getForms()[0].setParameter("endDate", "");
		wr = wr.getForms()[0].submit(wr.getForms()[0].getSubmitButton("test"));			
		wr = wr.getForms()[0].submit(wr.getForms()[0].getSubmitButton("cancel"));
		
		// Make sure the proper message exists in the right order
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("Scratchy Throat"));
		assertTrue(wr.getTables()[1].getRows()[1].getText().contains("2010-02-02 13:03"));	
		
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("Prescription"));
		assertTrue(wr.getTables()[1].getRows()[2].getText().contains("2010-01-31 12:12"));
				
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("RE: Lab Procedure"));
		assertTrue(wr.getTables()[1].getRows()[3].getText().contains("2010-01-29 17:58"));
				
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("Office Visit"));
		assertTrue(wr.getTables()[1].getRows()[4].getText().contains("2010-01-29 08:01"));
				
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("Random Person"));
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("Appointment"));
		assertTrue(wr.getTables()[1].getRows()[5].getText().contains("2010-01-19 07:58"));
				
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("Lab Results"));
		assertTrue(wr.getTables()[1].getRows()[6].getText().contains("2010-01-13 13:46"));
			
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("Baby Programmer"));
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("Remote Monitoring Question"));
		assertTrue(wr.getTables()[1].getRows()[7].getText().contains("2010-01-07 09:15"));
	}
	

	public void testHCPtestMessageFilter2() throws Exception {
		// Create DB for this test case
		String DIR = "sql/data";
		DAOFactory factory = TestDAOFactory.getTestInstance();
		new DBBuilder(factory).executeSQLFile(DIR + "/clearMessages.sql");
		new DBBuilder(factory).executeSQLFile(DIR + "/messageCase5.sql");
		
		// Login
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		assertLogged(TransactionType.HOME_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Message Inbox").click();
		assertLogged(TransactionType.INBOX_VIEW, 9000000000L, 0L, "");
		
		wr = wr.getLinkWith("Edit Filter").click();
		
		// Enter filter information where has words is influenza
		wr.getForms()[0].setParameter("sender", "");
		wr.getForms()[0].setParameter("subject", "");
		wr.getForms()[0].setParameter("hasWords", "influenza");
		wr.getForms()[0].setParameter("startDate", "");
		wr.getForms()[0].setParameter("notWords", "");
		wr.getForms()[0].setParameter("endDate", "");
		wr = wr.getForms()[0].submit(wr.getForms()[0].getSubmitButton("save"));
		
		// Make sure the proper message exists in the right order
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("Andy Programmer"));
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("Influenza Vaccine"));
		assertTrue(wr.getTables()[2].getRows()[1].getText().contains("2010-03-25 16:15"));
	}

	
}
