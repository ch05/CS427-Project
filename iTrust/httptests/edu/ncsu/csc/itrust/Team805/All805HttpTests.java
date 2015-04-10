package edu.ncsu.csc.itrust.Team805;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.ncsu.csc.itrust.Team805.UC14.RequestBiosurveillanceTest;
import edu.ncsu.csc.itrust.Team805.UC20.ViewCODTrendsTest;
import edu.ncsu.csc.itrust.Team805.UC30.MessagingFilterTest;
import edu.ncsu.csc.itrust.Team805.UC39.TransactionlogTest;
import edu.ncsu.csc.itrust.Team805.UC41.SendReminderActionTest;
import edu.ncsu.csc.itrust.Team805.UC63.OBInitializationTest;
import edu.ncsu.csc.itrust.Team805.UC64.OBVisitTest;
import edu.ncsu.csc.itrust.Team805.UC65.ErrorListTest;
import edu.ncsu.csc.itrust.Team805.UC65.FeatureControlTest;
import edu.ncsu.csc.itrust.Team805.UC65.NetworkInformationTest;

@RunWith(Suite.class)
@SuiteClasses({RequestBiosurveillanceTest.class,
	ViewCODTrendsTest.class,
	SendReminderActionTest.class,
	OBInitializationTest.class,
	OBVisitTest.class,
	ErrorListTest.class,
	FeatureControlTest.class,
	NetworkInformationTest.class,
	MessagingFilterTest.class,
	TransactionlogTest.class})
public class All805HttpTests {

}
