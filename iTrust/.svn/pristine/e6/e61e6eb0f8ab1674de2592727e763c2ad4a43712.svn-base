package edu.ncsu.csc.itrust.action;

import edu.ncsu.csc.itrust.action.base.PatientBaseAction;
import edu.ncsu.csc.itrust.beans.PatientBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.AuthDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.enums.Gender;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.exception.ITrustException;

public class AddObstetricsPatient extends PatientBaseAction{
	private AuthDAO authDAO;
	private PatientDAO patientDAO;
	private PersonnelDAO personnelDAO;
	long mid;
	
	public AddObstetricsPatient(DAOFactory factory, long loggedInMID, String pidString)
			throws ITrustException {
		super(factory, pidString);
		this.authDAO = factory.getAuthDAO();
		this.patientDAO = factory.getPatientDAO();
		this.personnelDAO = factory.getPersonnelDAO();
		this.mid = loggedInMID;
	}

	public PatientBean getPatient() throws DBException {
		return patientDAO.getPatient(this.getPid());
	}

	public Gender getGender() throws DBException{
		return patientDAO.getPatient(this.getPid()).getGender();
	}
	
	public String getSpecialty() throws DBException{
		return personnelDAO.getPersonnel(mid).getSpecialty();		
	}
}
