package edu.ncsu.csc.itrust.beans;

import java.sql.Timestamp;

/**
 * A bean for storing data about HTTP requests.
 * 
 * A bean's purpose is to store data. Period. Little or no functionality is to be added to a bean 
 * (with the exception of minor formatting such as concatenating phone numbers together). 
 * A bean must only have Getters and Setters (Eclipse Hint: Use Source > Generate Getters and Setters� 
 * to create these easily)
 */
public class RequestBean {
	private Timestamp Date;
	private int contentLength;
	private String requestedPage;
	private String userAgent;
	private String host;
	
	public Timestamp getDate() {
		return Date;
	}
	public void setDate(Timestamp date) {
		Date = date;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getRequestedPage() {
		return requestedPage;
	}
	public void setRequestedPage(String requestedPage) {
		this.requestedPage = requestedPage;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}

}
