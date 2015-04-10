package edu.ncsu.csc.itrust.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.ncsu.csc.itrust.beans.ApptBean;
import edu.ncsu.csc.itrust.beans.Email;
import edu.ncsu.csc.itrust.beans.MessageBean;
import edu.ncsu.csc.itrust.beans.PatientBean;
import edu.ncsu.csc.itrust.beans.PersonnelBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.ApptDAO;
import edu.ncsu.csc.itrust.dao.mysql.FakeEmailDAO;
import edu.ncsu.csc.itrust.dao.mysql.MessageDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.enums.TransactionType;

/**
 * Action class for sendReminder.jsp
 */
public class SendReminder {
	private DAOFactory prodDAO;
	private long adminMID;
	
	/**
	 * Constructor for the SendReminder class
	 * 
	 * @param factory The {@link DAOFactory} associated with this DAO, which is used for obtaining SQL connections, etc.
	 */
	public SendReminder(DAOFactory factory) {
		prodDAO = factory;
		this.adminMID = 9000000089L;
	}
	
	/**
	 * Sends appointment reminder notices via the internal message system and the fakeemail system
	 * 
	 * @param numDaysInAdvance The number of days from the current day
	 * @throws Exception
	 */
	public void send(int numDaysInAdvance) throws Exception {
		PatientDAO patientDAO = prodDAO.getPatientDAO();
		FakeEmailDAO fakeEmailDAO =  prodDAO.getFakeEmailDAO();
		MessageDAO messageDAO = prodDAO.getMessageDAO();
		PersonnelDAO personnelDAO = prodDAO.getPersonnelDAO();
		ApptDAO apptDAO = prodDAO.getApptDAO();
		EventLoggingAction logger = new EventLoggingAction(prodDAO);
		
		Timestamp currentTime = getCurrentTime();
		PersonnelBean admin = personnelDAO.getPersonnel(adminMID);
		
		List<PatientBean> patients = patientDAO.getPatientsForReminders(numDaysInAdvance);
		List<ApptBean> appointments = apptDAO.getAppointmentsForReminders(numDaysInAdvance);
		for(int i = 0; i < patients.size(); i++) {
			PatientBean patient = patients.get(i);
			ApptBean appointment = appointments.get(i);
			
			List<String> toEmail = new ArrayList<String>();
			toEmail.add(patient.getEmail());
			Timestamp apptTime = appointment.getDate();
			String doctor = personnelDAO.getName(appointment.getHcp());
			
			String fromEmail = admin.getEmail();			
			String body = "You have an appointment on " + apptTime.toString() + " with Dr. " + doctor;
			String subject = "Reminder: upcoming appointment in " + numDaysInAdvance + " day(s)";
			
			// Send fake email
			Email email = new Email();
			email.setToList(toEmail);
			email.setFrom(fromEmail);
			email.setSubject(subject);
			email.setBody(body);
			email.setTimeAdded(currentTime);
			fakeEmailDAO.sendEmailRecord(email);
			
			// Add message			
			MessageBean message = new MessageBean();
			message.setBody(body);
			message.setSubject(subject);
			message.setFrom(admin.getMID());
			message.setTo(patient.getMID());
			message.setSentDate(currentTime);
			messageDAO.addMessage(message);
			
			//Log that a reminder message has been sent
			logger.logEvent(TransactionType.SENT_REMINDERS, adminMID, patient.getMID(), "Appointment Reminder message sent");
		}
	}
	
	/**
	 * Helper function that constructs a formatted string for the current date and time
	 * 
	 * @return java.sql.Timestamp
	 */
	private Timestamp getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return Timestamp.valueOf(sdf.format(c.getTime()));
	}
}
