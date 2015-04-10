package edu.ncsu.csc.itrust.dao.error;

import java.util.List;

import org.junit.Test;

import edu.ncsu.csc.itrust.beans.ErrorBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.ErrorDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;
import junit.framework.TestCase;

public class ErrorTest extends TestCase{

	private DAOFactory factory = TestDAOFactory.getTestInstance();
	private ErrorDAO errorDAO = factory.getErrorDAO();

	@Override
	protected void setUp() throws Exception {
		TestDataGenerator gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.error1();
	}
	
	@Test
	public void testGetErrors() throws DBException {
		List<ErrorBean> errors = errorDAO.getErrors();
		
		assertTrue(errors.size() == 2);
		assertTrue(errors.get(0).getMid() == 1);
		assertTrue(errors.get(1).getMessage().equals("ClassNotFoundException: zxzxczczzdfs"));
	}
	
	@Test
	public void testAddError() throws DBException {
		ErrorBean eb = new ErrorBean();
		eb.setMessage("Test Message");
		
		errorDAO.addError(eb);
		
		List<ErrorBean> errors = errorDAO.getErrors();
		
		assertTrue(errors.size() == 3);
		assertTrue(eb.getMessage().equals("Test Message"));
	}
}
