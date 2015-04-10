package edu.ncsu.csc.itrust.Team805.UC30;

import junit.framework.TestCase;

import org.junit.Test;

import edu.ncsu.csc.itrust.action.EditPersonnelAction;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class EditPersonnelActionFilterTest extends TestCase {
	private DAOFactory factory;
	private long mid = 9000000000L;
	private String pidString = "9000000000";
	private EditPersonnelAction personnelAction;

	@Override
	protected void setUp() throws Exception {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.standardData();
		
		factory = TestDAOFactory.getTestInstance();
		personnelAction = new EditPersonnelAction(factory, mid, pidString);
	}
	
	@Test
	public void testEditMessageFilter() throws Exception {
		String filter = "testFilter";
		personnelAction.editMessageFilter(filter);
		PersonnelDAO personnelDAO = new PersonnelDAO(factory);
		
		assertEquals(personnelDAO.getPersonnel(mid).getMessageFilter(), filter);
	}

	 
}
