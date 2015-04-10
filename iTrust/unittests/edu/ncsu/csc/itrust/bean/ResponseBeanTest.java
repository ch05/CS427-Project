package edu.ncsu.csc.itrust.bean;

import java.sql.Timestamp;

import edu.ncsu.csc.itrust.beans.ResponseBean;
import junit.framework.TestCase;

public class ResponseBeanTest extends TestCase {

	/**
	 * testResponseBean
	 * @throws Exception
	 */
	public void testResponseBean() throws Exception {
		ResponseBean rb = new ResponseBean();
		
		rb.setContentLength(1000);
		assertEquals(1000, rb.getContentLength());
		
		rb.setLatency(100.0);
		assertEquals(100.0, rb.getLatency());
		
		rb.setRequestedPage("/test/");
		assertEquals("/test/", rb.getRequestedPage());
		
		rb.setDate(Timestamp.valueOf("2014-5-20 11:11:11"));
		assertEquals(Timestamp.valueOf("2014-5-20 11:11:11"), rb.getDate());
	}
	
}
