package edu.ncsu.csc.itrust.bean;

import java.sql.Timestamp;

import edu.ncsu.csc.itrust.beans.ErrorBean;
import junit.framework.TestCase;

public class ErrorBeanTest extends TestCase {

	/**
	 * testErrorBean
	 * @throws Exception
	 */
	public void testErrorBean() throws Exception {
		ErrorBean eb = new ErrorBean();
		
		eb.setMessage("Test Message");
		assertEquals("Test Message", eb.getMessage());
		
		eb.setMid(900000L);
		assertEquals(900000L, eb.getMid());
		
		eb.setRequestedPage("/testPage/");
		assertEquals("/testPage/", eb.getRequestedPage());
		
		eb.setTimestamp(Timestamp.valueOf("2014-5-20 11:11:11"));
		assertEquals(Timestamp.valueOf("2014-5-20 11:11:11"), eb.getTimestamp());
	}	
}
