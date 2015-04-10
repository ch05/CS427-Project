package edu.ncsu.csc.itrust.beans;

import java.sql.Timestamp;

/**
 * A bean for storing data about http responses.
 * 
 * A bean's purpose is to store data. Period. Little or no functionality is to be added to a bean 
 * (with the exception of minor formatting such as concatenating phone numbers together). 
 * A bean must only have Getters and Setters (Eclipse Hint: Use Source > Generate Getters and Setters� 
 * to create these easily)
 */
public class ResponseBean {
	private int contentLength;
	private Timestamp date;
	private double latency;
	private String requestedPage;

	public ResponseBean() {
	}
	
	public String getRequestedPage() {
		return requestedPage;
	}

	public void setRequestedPage(String requestedPage) {
		this.requestedPage = requestedPage;
	}
	
	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public double getLatency() {
		return latency;
	}

	public void setLatency(double latency) {
		this.latency = latency;
	}
}
