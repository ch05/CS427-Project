package edu.ncsu.csc.itrust.bean;

import java.sql.Timestamp;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.beans.RequestBean;

public class RequestBeanTest extends TestCase {
	
	public void testRequestBean() throws Exception {
		RequestBean request = new RequestBean();
		request.setContentLength(50);
		request.setDate(Timestamp.valueOf("2014-11-11 11:11:11"));
		request.setHost("testHost");
		request.setRequestedPage("testPage");
		request.setUserAgent("testUserAgent");
		
		assertEquals(request.getContentLength(), 50);
		assertEquals(request.getDate(), Timestamp.valueOf("2014-11-11 11:11:11"));
		assertEquals(request.getHost(), "testHost");
		assertEquals(request.getRequestedPage(), "testPage");
		assertEquals(request.getUserAgent(), "testUserAgent");
	}
}
