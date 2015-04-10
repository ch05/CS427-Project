package edu.ncsu.csc.itrust.Team805.UC14;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.EpidemicDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.exception.ITrustException;
import edu.ncsu.csc.itrust.testutils.EvilDAOFactory;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

public class EpidemicDAOTest {
	private DAOFactory factory = TestDAOFactory.getTestInstance();
	private DAOFactory evilFactory = EvilDAOFactory.getEvilInstance();
	private TestDataGenerator tdg = new TestDataGenerator();
	private EpidemicDAO epd;
	private EpidemicDAO evilepd;

	@Before
	public void setUp() throws Exception {
		epd = new EpidemicDAO(factory);
		evilepd = new EpidemicDAO(evilFactory);
		tdg.clearAllTables();
		tdg.standardData();
	}
	@Test
	public void testMalariaThreshold() throws DBException, ITrustException {
		assertTrue(epd.malariaEpidemicThreshold("27601", Date.valueOf("2014-11-09")) == 2);
	}
	
	@Test
	public void testMalariaEpidemic() throws DBException, ITrustException {
		assertTrue(epd.isMalariaEpidemic("27601", Date.valueOf("2014-11-09")));
	}
	
	@Test
	public void testNotMalariaEpidemicYear() throws DBException, ITrustException {
		assertTrue(!epd.isMalariaEpidemic("27601", Date.valueOf("2000-11-09")));
	}
	
	@Test
	public void testNotMalariaEpidemicZip() throws DBException, ITrustException {
		assertTrue(!epd.isMalariaEpidemic("12345", Date.valueOf("2014-11-09")));
	}
	
	@Test
	public void testErrorMalariaThreshold(){
		try {
			evilepd.malariaEpidemicThreshold("27601", Date.valueOf("2014-11-09"));
			assertTrue(false);
		} catch (DBException e) {
			assertTrue(true);
		} catch (ITrustException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testErrorMalariaEpidemic(){
		try {
			evilepd.isMalariaEpidemic("27601", Date.valueOf("2014-11-09"));
			assertTrue(false);
		} catch (DBException e) {
			assertTrue(true);
		} catch (ITrustException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testInfluenzaThreshold() throws DBException, ITrustException {
		assertTrue(Math.round(epd.influenzaEpidemicThreshold(Date.valueOf("2014-11-09"))) == 22);
	}
	
	@Test
	public void testInfluenzaEpidemic() throws DBException, ITrustException {
		assertTrue(epd.isInfluenzaEpidemic("27601", Date.valueOf("2014-11-09")));
	}
	
	@Test
	public void testNotInfluenzaEpidemicYear() throws DBException, ITrustException {
		assertTrue(!epd.isInfluenzaEpidemic("27601", Date.valueOf("2000-11-09")));
	}
	
	@Test
	public void testNotInfluenzaEpidemicZip() throws DBException, ITrustException {
		assertTrue(!epd.isInfluenzaEpidemic("12345", Date.valueOf("2014-11-09")));
	}
	
	@Test
	public void testErrorInfluenzaEpidemic(){
		try {
			evilepd.isInfluenzaEpidemic("27601", Date.valueOf("2014-11-09"));
			assertTrue(false);
		} catch (DBException e) {
			assertTrue(true);
		} catch (ITrustException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testDiagnosisRegion(){
		try {
			List<Integer> l = epd.diagnosisRegion("27601", new Date(System.currentTimeMillis()), "487.00");
			assertTrue(l.get(4) == 100);
		} catch (DBException e) {
			assertTrue(false);
		} catch (ITrustException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testDiagnosisState(){
		try {
			List<Integer> l = epd.diagnosisState("27601", new Date(System.currentTimeMillis()), "487.00");
			assertTrue(l.get(4) == 100);
		} catch (DBException e) {
			assertTrue(false);
		} catch (ITrustException e) {
			assertTrue(false);
		}
	}
	@Test
	public void testDiagnosisAll(){
		try {
			List<Integer> l = epd.diagnosisAll("27601", new Date(System.currentTimeMillis()), "84.5");
			assertTrue(l.get(4) == 6);
		} catch (DBException e) {
			assertTrue(false);
		} catch (ITrustException e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testICDCodeExists(){
		assertTrue(epd.checkIfDiagnosisCodeExists("487.00"));
	}
	
	@Test
	public void testICDCodeNotExists(){
		assertTrue(!epd.checkIfDiagnosisCodeExists("1.03"));
	}
	
	@Test
	public void testZipCodeExists(){
		assertTrue(epd.checkIfZipCodeExists("60123"));
	}
	
	@Test
	public void testZipCodeNotExists(){
		assertTrue(!epd.checkIfDiagnosisCodeExists("60124"));
	}
}
