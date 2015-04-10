package edu.ncsu.csc.itrust.Team805.UC65;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.FeatureDAO;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class FeatureControlTest extends iTrustHTTPTest {
	private DAOFactory factory;
	private FeatureDAO feaDAO;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.standardData();
		factory = TestDAOFactory.getTestInstance();
		feaDAO = factory.getFeatureDAO();
		feaDAO.enableFeature("Patient View My Diagnoses", false);
	}
	
	public void testDisableFeature() throws Exception {		
		//Login as Patient
		WebConversation wc = login("1", "pw");	
		WebResponse wr = wc.getCurrentPage();
		
		wr = wr.getLinkWith("My Diagnoses").click();
		assertTrue(wr.getText().contains("This Feature is unavailable"));
	}
	
	public void testEnableFeature() throws Exception {	
		feaDAO.enableFeature("Patient View My Diagnoses", true);
		
		//Login as Patient
		WebConversation wc = login("1", "pw");	
		WebResponse wr = wc.getCurrentPage();
		
		wr = wr.getLinkWith("My Diagnoses").click();
		assertFalse(wr.getText().contains("This Feature is unavailable"));
	}
}
