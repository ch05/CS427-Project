package edu.ncsu.csc.itrust.dao.response;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.dao.mysql.ResponseDAO;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.testutils.EvilDAOFactory;

public class ResponseDAOExceptionTest extends TestCase {
	private ResponseDAO evilDAO = EvilDAOFactory.getEvilInstance().getResponseDAO();

	@Override
	protected void setUp() throws Exception {
	}
	
	public void testGetResponsesException() throws Exception {
		try{
			evilDAO.getResponses();
			fail("DBException should have been thrown");
		} catch(DBException e){
			assertEquals(EvilDAOFactory.MESSAGE, e.getSQLException().getMessage());
		}
	}
}
