package edu.ncsu.csc.itrust.Team805.UC41;

import edu.ncsu.csc.itrust.action.SendReminder;
import edu.ncsu.csc.itrust.beans.Email;
import edu.ncsu.csc.itrust.beans.MessageBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.FakeEmailDAO;
import edu.ncsu.csc.itrust.dao.mysql.MessageDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

import java.util.List;

import junit.framework.TestCase;


public class SendReminderActionTest extends TestCase {
	private DAOFactory factory;
	private MessageDAO messageDAO;
	private FakeEmailDAO fakeEmailDAO;
	private PatientDAO patientDAO;
	private TestDataGenerator gen;
	private SendReminder sendReminder;
	private long reminderAdminID;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gen = new TestDataGenerator();
		gen.clearAllTables();
		gen.standardData();
		
		this.reminderAdminID = 9000000089L;
		this.factory = TestDAOFactory.getTestInstance();
		this.messageDAO = new MessageDAO(this.factory);
		this.fakeEmailDAO = new FakeEmailDAO(this.factory);
		this.sendReminder =  new SendReminder(this.factory);
		this.patientDAO = new PatientDAO(this.factory);
	}
	
	public void testSend() throws Exception {
		String subject = "Reminder: upcoming appointment in 8 day(s)";
		sendReminder.send(8);
		int numSent = patientDAO.getPatientsForReminders(8).size();
		
		// Send message
		List<MessageBean> mbList = this.messageDAO.getMessagesFrom(reminderAdminID);
		assertEquals(numSent, mbList.size());
		
		if (numSent != 0){
			MessageBean mBeanDB = mbList.get(0);
			assertEquals(reminderAdminID, mBeanDB.getFrom());
			assertEquals(subject, mBeanDB.getSubject());
			assertTrue(mBeanDB.getBody().contains("You have an appointment on"));
			assertTrue(mBeanDB.getBody().contains("with Dr. Kelly Doctor"));
		
			// Send a fake email
			List<Email> emails = this.fakeEmailDAO.getSentEmailsByPerson("System Reminder");
			assertEquals(numSent, emails.size());
			
			Email email = emails.get(0);
			assertEquals("System Reminder", email.getFrom());
			assertEquals(subject, email.getSubject());
			assertTrue(email.getBody().contains("You have an appointment on"));
			assertTrue(email.getBody().contains("with Dr. Kelly Doctor"));
		}
		
	}

}
