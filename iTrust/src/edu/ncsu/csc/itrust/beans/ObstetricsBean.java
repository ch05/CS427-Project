package edu.ncsu.csc.itrust.beans;

import java.sql.Date;
import java.util.Calendar;

public class ObstetricsBean {
	public int yearOfConception;
	public String numWeeksPregnant;
	public Double numHoursInLabor;
	public String deliveryType;
	public Date LMP;
	
	public long patientMID;
	
	public int numWeeksPregVisit;
	public double numPounds;
	public int heartRate;
	public int bloodPressure;
	public double fundalHeight;
	public int initID;
	
	/**
	 * Creates a new ObstetricsBean
	 * @param _yearOfConception Year of Conception
	 * @param numWeeksPreg # Weeks Preg
	 * @param numHoursLabor # Hours Labor
	 * @param delivType Delivery Type
	 * @param _LMP Last Menstrual Period
	 * @param _patientMID Patient MID
	 */
	public ObstetricsBean(int _yearOfConception, String numWeeksPreg, Double numHoursLabor, String delivType, Date _LMP, long _patientMID){
		yearOfConception = _yearOfConception;
		numWeeksPregnant = numWeeksPreg;
		numHoursInLabor = numHoursLabor;
		deliveryType = delivType;
		LMP = _LMP;
		patientMID = _patientMID;
	}
	
	/**
	 * Creates a new ObstetricsBean
	 * @param _yearOfConception Year of Conception
	 * @param numWeeksPreg # Weeks Preg
	 * @param numHoursLabor # Hours Labor
	 * @param delivType Delivery Type
	 * @param _LMP Last Menstrual Period
	 * @param _patientMID Patient MID
	 */
	public ObstetricsBean(int numWeeksPregVisit, Double numPounds, int heartRate, int bloodPressure, double fundalHeight, long _patientMID, int initID){
		this.numWeeksPregVisit = numWeeksPregVisit;
		this.numPounds = numPounds;
		this.heartRate = heartRate;
		this.bloodPressure = bloodPressure;
		this.fundalHeight = fundalHeight;
		this.initID = initID;
		this.patientMID = _patientMID;
	}
	
	/**
	 * Returns the estimated due date of this obstetrics bean
	 * @return
	 */
	public Date getEDD(){
		Calendar c = Calendar.getInstance();
		c.setTime(LMP);
		c.add(Calendar.DATE, 280);
		
		return new Date(c.getTimeInMillis());
	}
	
	/**
	 * Prints the obstetrics bean in a readable format
	 */
	public void print(){
		System.out.println("\n------------------------------------");
		System.out.println("YOC: " + yearOfConception);
		System.out.println("# Preg: " + numWeeksPregnant);
		System.out.println("# Labor: " + numHoursInLabor);
		System.out.println("Deliv Type: " + deliveryType);
		System.out.println("LMP: " + LMP);
		System.out.println("MID: " + patientMID);
		System.out.println("\n------------------------------------");

	}
	
	/**
	 * Determines if this obstetrics bean is equal to another
	 * @param ob Obstetrics bean to compare to
	 * @return True if they are equal, false otherwise
	 */
	public boolean equalTo(ObstetricsBean ob){
		
		return ob.yearOfConception == this.yearOfConception &&
				ob.numHoursInLabor.equals(this.numHoursInLabor) &&
				ob.numWeeksPregnant.equals(this.numWeeksPregnant) &&
				ob.deliveryType.equals(this.deliveryType) && 
				ob.LMP.compareTo(this.LMP) == 0 &&
				ob.patientMID == this.patientMID;
	}
	
}
