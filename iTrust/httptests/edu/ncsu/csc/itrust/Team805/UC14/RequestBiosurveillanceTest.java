package edu.ncsu.csc.itrust.Team805.UC14;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.http.iTrustHTTPTest;

/**
 * UC 14 - httptests
 */
public class RequestBiosurveillanceTest extends iTrustHTTPTest{
	private TestDataGenerator gen = new TestDataGenerator();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen.clearAllTables();
		gen.standardData();	
	}
	
	/**
	 * Test if the default values function normally 
	 */
	public void testInfluenzaEpidemicsDefault() throws Exception{//ICD Code = 487.00, ZipCode = 27601, Date = Nov.20, 2014
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Test default values of Influenza Epidemics
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "487");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "11/20/2014");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Influenza diagnosis: false"));												
	}
	
	/**
	 * Test if the the function work on specific known Malaria input 
	 */
	public void testMalariaEpidemicsTrue() throws Exception{//ICD Code = 487.00, ZipCode = 27601, Date = Nov.11, 2014
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Test Influenza Epidemics until Nov.11, 2014, which should return true according to the existing data
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "84.5");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "11/11/2014");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Malaria diagnosis: true"));												
	}
	
	/**
	 * Test if the the function work on specific known Influenza input 
	 */
	public void testInfluenzaEpidemicsTrue() throws Exception{//ICD Code = 487.00, ZipCode = 27601, Date = Nov.11, 2014
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Test Influenza Epidemics until Nov.11, 2014, which should return true according to the data
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "487");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "11/11/2014");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("Influenza diagnosis: true"));												
	}
	
	/**
	 * Test if the error message is displayed with an invalid ICD code
	 */
	public void testInvalidDiagnosesCode1() throws Exception{//ICD Code = 250.10(invalid for Epidemics), ZipCode = 27601, Date = Oct.20, 1985
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Test Diabetes with ketoacidosis until Oct.20, 1985, which should return invalid(Epidemics only works for influenza and malaria)
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "250.10");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "10/20/1985");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("The diagnosis code is invalid. Please try again."));												
	}
	
	/**
	 * Test if the error message is displayed with a diagnoses code other than 84.5 or 487.00 when Epidemics is selected
	 */
	public void testInvalidDiagnosesCode2() throws Exception{//ICD Code = 12345(invalid), ZipCode = 27601, Date = Oct.20, 1985
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Test Diabetes with ICD = 12345, which should return invalid(Input ICD code does not exist in the database)
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "12345");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "10/20/1985");
		form.setParameter("Option", "Diagnoses");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("The ICD code is invalid. Please try again."));												
	}
	
	/**
	 * Test if the error message is displayed with an invalid zip code that is not in the database
	 */
	public void testInvalidZipCode()throws Exception{//ICD Code = 250.10, ZipCode = 12345(invalid), Date = Oct.20, 1985
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Input an invalid zipcode that is not in the database
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "250.10");
		form.setParameter("ZipCode", "12345");
		form.setParameter("schedDate", "10/20/1985");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("The zip code is invalid. Please try again."));												
	}
	
	/**
	 * Test if the error message is displayed with an invalid future date
	 */
	public void testInvalidDate1()throws Exception{//ICD Code = 250.10, ZipCode = 27061, Date = Nov.20, 2050(invalid future date)
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Input an invalid zipcode that is not in the database
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "250.10");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "11/20/2050");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("The date is invalid. Please try again."));												
	}
	
	/**
	 * Test if the error message is displayed with an invalid month
	 */
	public void testInvalidDate2()throws Exception{//ICD Code = 250.10, ZipCode = 27061, Date = Nov.32, 2014(invalid future date)
		//Log in as Kelly Doctor
		WebConversation wc = login("9000000000", "pw");
		WebResponse wr = wc.getCurrentPage();
		
		//Go to the Request Biosurveillance page
		wr = wr.getLinkWith("Request Biosurveillance").click();
		assertEquals("iTrust - Request Biosurveillance", wr.getTitle());		
		
		assertTrue(wr.getText().contains("ICD Code"));
		assertTrue(wr.getText().contains("Zip Code"));
		assertTrue(wr.getText().contains("Date"));
		assertTrue(wr.getText().contains("Option"));
		
		//Input an invalid zipcode that is not in the database
		WebForm form = wr.getForms()[0];
		form.setParameter("ICDCode", "250.10");
		form.setParameter("ZipCode", "27601");
		form.setParameter("schedDate", "11/32/2014");
		form.setParameter("Option", "Epidemics");
		form.getSubmitButtons()[0].click();
		
		wr = wc.getCurrentPage();
		assertTrue(wr.getText().contains("The date is invalid. Please try again."));												
	}
}
