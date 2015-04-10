package edu.ncsu.csc.itrust.dao;

import java.sql.Connection;
import java.sql.SQLException;

import edu.ncsu.csc.itrust.dao.mysql.AccessDAO;
import edu.ncsu.csc.itrust.dao.mysql.AdverseEventDAO;
import edu.ncsu.csc.itrust.dao.mysql.AllergyDAO;
import edu.ncsu.csc.itrust.dao.mysql.ApptDAO;
import edu.ncsu.csc.itrust.dao.mysql.ApptRequestDAO;
import edu.ncsu.csc.itrust.dao.mysql.ApptTypeDAO;
import edu.ncsu.csc.itrust.dao.mysql.AuthDAO;
import edu.ncsu.csc.itrust.dao.mysql.BillingDAO;
import edu.ncsu.csc.itrust.dao.mysql.CPTCodesDAO;
import edu.ncsu.csc.itrust.dao.mysql.DiagnosesDAO;
import edu.ncsu.csc.itrust.dao.mysql.DrugInteractionDAO;
import edu.ncsu.csc.itrust.dao.mysql.DrugReactionOverrideCodesDAO;
import edu.ncsu.csc.itrust.dao.mysql.ErrorDAO;
import edu.ncsu.csc.itrust.dao.mysql.FakeEmailDAO;
import edu.ncsu.csc.itrust.dao.mysql.FamilyDAO;
import edu.ncsu.csc.itrust.dao.mysql.FeatureDAO;
import edu.ncsu.csc.itrust.dao.mysql.HealthRecordsDAO;
import edu.ncsu.csc.itrust.dao.mysql.HospitalsDAO;
import edu.ncsu.csc.itrust.dao.mysql.ICDCodesDAO;
import edu.ncsu.csc.itrust.dao.mysql.LOINCDAO;
import edu.ncsu.csc.itrust.dao.mysql.LabProcedureDAO;
import edu.ncsu.csc.itrust.dao.mysql.MessageDAO;
import edu.ncsu.csc.itrust.dao.mysql.NDCodesDAO;
import edu.ncsu.csc.itrust.dao.mysql.OfficeVisitDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientInstructionsDAO;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.dao.mysql.PrescriptionReportDAO;
import edu.ncsu.csc.itrust.dao.mysql.PrescriptionsDAO;
import edu.ncsu.csc.itrust.dao.mysql.ProceduresDAO;
import edu.ncsu.csc.itrust.dao.mysql.ReferralDAO;
import edu.ncsu.csc.itrust.dao.mysql.RemoteMonitoringDAO;
import edu.ncsu.csc.itrust.dao.mysql.ReportRequestDAO;
import edu.ncsu.csc.itrust.dao.mysql.RequestDAO;
import edu.ncsu.csc.itrust.dao.mysql.RequiredProceduresDAO;
import edu.ncsu.csc.itrust.dao.mysql.ResponseDAO;
import edu.ncsu.csc.itrust.dao.mysql.ReviewsDAO;
import edu.ncsu.csc.itrust.dao.mysql.RiskDAO;
import edu.ncsu.csc.itrust.dao.mysql.SurveyDAO;
import edu.ncsu.csc.itrust.dao.mysql.SurveyResultDAO;
import edu.ncsu.csc.itrust.dao.mysql.TransactionDAO;
import edu.ncsu.csc.itrust.dao.mysql.VisitRemindersDAO;
import edu.ncsu.csc.itrust.dao.mysql.ZipCodeDAO;
import edu.ncsu.csc.itrust.testutils.EvilDAOFactory;
import edu.ncsu.csc.itrust.testutils.TestDAOFactory;

/**
 * The central mediator for all Database Access Objects. The production instance uses the database connection
 * pool provided by Tomcat (so use the production instance when doing stuff from JSPs in the "real code").
 * Both the production and the test instance parses the context.xml file to get the JDBC connection.
 * 
 * Also, @see {@link EvilDAOFactory} and @see {@link TestDAOFactory}.
 * 
 * Any DAO that is added to the system should be added in this class, in the same way that all other DAOs are.
 * 
 *  
 * 
 */
public class DAOFactory {
	private static DAOFactory productionInstance = null;
	private IConnectionDriver driver;

	/**
	 * 
	 * @return A production instance of the DAOFactory, to be used in deployment (by Tomcat).
	 */
	public static DAOFactory getProductionInstance() {
			productionInstance = new DAOFactory();
		return productionInstance;
	}

	/**
	 * Protected constructor. Call getProductionInstance to get an instance of the DAOFactory
	 */
	protected DAOFactory() {
		this.driver = new ProductionConnectionDriver();
	}

	/**
	 * 
	 * @return this DAOFactory's Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return driver.getConnection();
	}

	/**
	 * 
	 * @return this DAOFactory's AccessDAO
	 */
	public AccessDAO getAccessDAO() {
		return new AccessDAO(this);
	}
	
	/**
	 *
	 * @return this DAOFactory's ZipCodeDAO
	 */
	public ZipCodeDAO getZipCodeDAO()
	{
		return new ZipCodeDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's AllergyDAO
	 */
	public AllergyDAO getAllergyDAO() {
		return new AllergyDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ApptDAO
	 */
	public ApptDAO getApptDAO() {
		return new ApptDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ApptRequestDAO
	 */
	public ApptRequestDAO getApptRequestDAO() {
		return new ApptRequestDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ApptTypeDAO
	 */
	public ApptTypeDAO getApptTypeDAO() {
		return new ApptTypeDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's AuthDAO
	 */
	public AuthDAO getAuthDAO() {
		return new AuthDAO(this);
	}
	
	/**
	 * 
	 * @return this DAOFactory's BillingDAO
	 */
	public BillingDAO getBillingDAO() {
		return new BillingDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's CPTCodesDAO
	 */
	public CPTCodesDAO getCPTCodesDAO() {
		return new CPTCodesDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's DrugInteractionDAO
	 */
	public DrugInteractionDAO getDrugInteractionDAO() {
		return new DrugInteractionDAO(this);
	}
	
	/**
	 * 
	 * @return this DAOFactory's ErrorDAO
	 */
	public ErrorDAO getErrorDAO() {
		return new ErrorDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's FamilyDAO
	 */
	public FamilyDAO getFamilyDAO() {
		return new FamilyDAO(this);
	}
	
	/**
	 * 
	 * @return this DAOFactory's FeatureDAO
	 */
	public FeatureDAO getFeatureDAO() {
		return new FeatureDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's HealthRecordsDAO
	 */
	public HealthRecordsDAO getHealthRecordsDAO() {
		return new HealthRecordsDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's HospitalsDAO
	 */
	public HospitalsDAO getHospitalsDAO() {
		return new HospitalsDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ICDCodesDAO
	 */
	public ICDCodesDAO getICDCodesDAO() {
		return new ICDCodesDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's NDCodesDAO
	 */
	public NDCodesDAO getNDCodesDAO() {
		return new NDCodesDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's OfficeVisitDAO
	 */
	public OfficeVisitDAO getOfficeVisitDAO() {
		return new OfficeVisitDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's PatientDAO
	 */
	public PatientDAO getPatientDAO() {
		return new PatientDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's PersonnelDAO
	 */
	public PersonnelDAO getPersonnelDAO() {
		return new PersonnelDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ReferralDAO
	 */
	public ReferralDAO getReferralDAO() {
		return new ReferralDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's RiskDAO
	 */
	public RiskDAO getRiskDAO() {
		return new RiskDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's TransactionDAO
	 */
	public TransactionDAO getTransactionDAO() {
		return new TransactionDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's VisitRemindersDAO
	 */
	public VisitRemindersDAO getVisitRemindersDAO() {
		return new VisitRemindersDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's FakeEmailDAO
	 */
	public FakeEmailDAO getFakeEmailDAO() {
		return new FakeEmailDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ReportRequestDAO
	 */
	public ReportRequestDAO getReportRequestDAO() {
		return new ReportRequestDAO(this);
	}
	
	/**
	 * 
	 * @return this DAOFactory's ResponseDAO
	 */
	public ResponseDAO getResponseDAO() {
		return new ResponseDAO(this);
	}
	
	/**
	 * 
	 * @return this DAOFactory's ResponseDAO
	 */
	public RequestDAO getRequestDAO() {
		return new RequestDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's SurveyDAO
	 */
	public SurveyDAO getSurveyDAO() {
		return new SurveyDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's LabProcedureDAO
	 */
	public LabProcedureDAO getLabProcedureDAO() {
		return new LabProcedureDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's LOINCDAO
	 */
	public LOINCDAO getLOINCDAO() {
		return new LOINCDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's SurveyResultDAO
	 */
	public SurveyResultDAO getSurveyResultDAO() {
		return new SurveyResultDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's MessageDAO
	 */
	public MessageDAO getMessageDAO() {
		return new MessageDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's AdverseEventDAO
	 */
	public AdverseEventDAO getAdverseEventDAO() {
		return new AdverseEventDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's RemoteMonitoringDAO
	 */
	public RemoteMonitoringDAO getRemoteMonitoringDAO() {
		return new RemoteMonitoringDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's PrescriptionsDAO
	 */
	public PrescriptionsDAO getPrescriptionsDAO() {
		return new PrescriptionsDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's DiagnosesDAO
	 */
	public DiagnosesDAO getDiagnosesDAO() {
		return new DiagnosesDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's ProceduresDAO
	 */
	public ProceduresDAO getProceduresDAO() {
		return new ProceduresDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's PrescriptionReportDAO
	 */
	public PrescriptionReportDAO getPrescriptionReportDAO() {
		return new PrescriptionReportDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's DrugReactionOverrideCodesDAO
	 */
	public DrugReactionOverrideCodesDAO getORCodesDAO() {
		return new DrugReactionOverrideCodesDAO(this);
	}

	/**
	 * 
	 * @return this DAOFactory's PatientInstructionsDAO
	 */
	public PatientInstructionsDAO getPatientInstructionsDAO() {
		return new PatientInstructionsDAO(this);
	}
	
	/**
	 * Gets the DAO for interaction with database table requiredprocedures.
	 * 
	 * @return this DAOFactory's RequiredProceduresDAO
	 */
	public RequiredProceduresDAO getRequiredProceduresDAO() {
		return new RequiredProceduresDAO(this);
	}

	/**
	 * Gets the DAO for reviews with the DB table reviews.
	 * @return this DAOFactory's ReviewsDAO
	 */
	public ReviewsDAO getReviewsDAO() {
		return new ReviewsDAO(this);
	}
}
