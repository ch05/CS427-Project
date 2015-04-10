package edu.ncsu.csc.itrust.Team805;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.ncsu.csc.itrust.Team805.UC14.EpidemicDAOTest;
import edu.ncsu.csc.itrust.Team805.UC20.CODTrendsTest;
import edu.ncsu.csc.itrust.Team805.UC30.EditPatientActionFilterTest;
import edu.ncsu.csc.itrust.Team805.UC30.EditPatientFilterTest;
import edu.ncsu.csc.itrust.Team805.UC30.EditPersonnelActionFilterTest;
import edu.ncsu.csc.itrust.Team805.UC30.EditPersonnelFilterTest;
import edu.ncsu.csc.itrust.Team805.UC30.ViewMyMessagesFilterTest;
import edu.ncsu.csc.itrust.Team805.UC41.SendReminderActionTest;
import edu.ncsu.csc.itrust.Team805.UC63_UC64.ObstetricsTest;
import edu.ncsu.csc.itrust.Team805.UC65.ErrorDAOExceptionTest;
import edu.ncsu.csc.itrust.Team805.UC65.ErrorTest;
import edu.ncsu.csc.itrust.Team805.UC65.FeatureDAOExceptionTest;
import edu.ncsu.csc.itrust.Team805.UC65.FeatureTest;
import edu.ncsu.csc.itrust.Team805.UC65.RequestDAOTest;
import edu.ncsu.csc.itrust.Team805.UC65.ResponseDAOExceptionTest;
import edu.ncsu.csc.itrust.Team805.UC65.ResponseTest;

@RunWith(Suite.class)
@SuiteClasses({EpidemicDAOTest.class,
	CODTrendsTest.class,
	SendReminderActionTest.class,
	ObstetricsTest.class,
	ErrorDAOExceptionTest.class,
	ErrorTest.class,
	FeatureDAOExceptionTest.class,
	FeatureTest.class,
	RequestDAOTest.class,
	ResponseDAOExceptionTest.class,
	RequestDAOTest.class,
	ResponseTest.class,
	ViewMyMessagesFilterTest.class,
	EditPatientFilterTest.class,
	EditPersonnelFilterTest.class,
	EditPersonnelActionFilterTest.class,
	EditPatientActionFilterTest.class
	})
public class All805UnitTests {

}
