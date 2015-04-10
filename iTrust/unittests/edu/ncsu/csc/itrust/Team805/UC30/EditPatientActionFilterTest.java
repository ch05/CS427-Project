package edu.ncsu.csc.itrust.Team805.UC30;

import junit.framework.TestCase;

import org.junit.Test;

import edu.ncsu.csc.itrust.action.EditPatientAction;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class EditPatientActionFilterTest extends TestCase {
	private DAOFactory factory;
	private long mid = 1L;
	private String pidString = "1";
	private EditPatientAction patientAction;

	@Override
	protected void setUp() throws Exception {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.standardData();
		
		factory = TestDAOFactory.getTestInstance();
		patientAction = new EditPatientAction(factory, mid, pidString);
	}
	
	@Test
	public void testEditMessageFilter() throws Exception {
		String filter = "testFilter";
		patientAction.editMessageFilter(filter);
		PatientDAO patientDAO = new PatientDAO(factory);
		
		assertEquals(patientDAO.getPatient(mid).getMessageFilter(), filter);
	}

	 
}
