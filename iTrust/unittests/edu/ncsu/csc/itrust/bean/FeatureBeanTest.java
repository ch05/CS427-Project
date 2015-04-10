package edu.ncsu.csc.itrust.bean;

import edu.ncsu.csc.itrust.beans.FeatureBean;
import junit.framework.TestCase;

public class FeatureBeanTest extends TestCase {

	/**
	 * testFeatureBean
	 * @throws Exception
	 */
	public void testFeatureBean() throws Exception {
		FeatureBean fb = new FeatureBean();
		
		fb.setEnabled(true);
		assertEquals(true, fb.isEnabled());
		
		fb.setFeatureName("Test Feature");
		assertEquals("Test Feature", fb.getFeatureName());
		
		fb.setFilePath("/testPath/");
		assertEquals("/testPath/", fb.getFilePath());
	}	
}
