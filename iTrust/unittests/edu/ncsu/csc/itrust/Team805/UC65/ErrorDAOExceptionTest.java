package edu.ncsu.csc.itrust.Team805.UC65;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.dao.mysql.ErrorDAO;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.testutils.EvilDAOFactory;

public class ErrorDAOExceptionTest extends TestCase {
	private ErrorDAO evilDAO = EvilDAOFactory.getEvilInstance().getErrorDAO();

	@Override
	protected void setUp() throws Exception {
	}
	
	public void testGetErrorsException() throws Exception {
		try{
			evilDAO.getErrors();
			fail("DBException should have been thrown");
		} catch(DBException e){
			assertEquals(EvilDAOFactory.MESSAGE, e.getSQLException().getMessage());
		}
	}
}
