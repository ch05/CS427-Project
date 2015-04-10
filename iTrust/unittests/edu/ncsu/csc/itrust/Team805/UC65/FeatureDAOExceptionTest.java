package edu.ncsu.csc.itrust.Team805.UC65;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.dao.mysql.FeatureDAO;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.testutils.EvilDAOFactory;

public class FeatureDAOExceptionTest extends TestCase {
	private FeatureDAO evilDAO = EvilDAOFactory.getEvilInstance().getFeatureDAO();

	@Override
	protected void setUp() throws Exception {
	}
	
	public void testGetFeaturesException() throws Exception {
		try{
			evilDAO.getFeatures();
			fail("DBException should have been thrown");
		} catch(DBException e){
			assertEquals(EvilDAOFactory.MESSAGE, e.getSQLException().getMessage());
		}
	}
	
	public void testEnableFeatureException() throws Exception {
		try{
			evilDAO.enableFeature("Doesn't exist", true);
			fail("DBException should have been thrown");
		} catch(DBException e){
			assertEquals(EvilDAOFactory.MESSAGE, e.getSQLException().getMessage());
		}
	}

}