package edu.ncsu.csc.itrust.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ncsu.csc.itrust.action.EventLoggingAction;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.FeatureDAO;
import edu.ncsu.csc.itrust.enums.TransactionType;
import edu.ncsu.csc.itrust.exception.DBException;


public class FeatureControlServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * FeatureControlServlet
	 * 
	 * Servlet is used for ajax requests to enable or disable a feature.
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String featureName = request.getParameter("featureName");
		String enabled = request.getParameter("enable");
		String mid = request.getParameter("mid");
		
		DAOFactory factory = DAOFactory.getProductionInstance();
		FeatureDAO feaDAO = factory.getFeatureDAO();
		EventLoggingAction loggingAction = new EventLoggingAction(factory);
		
		try {
			loggingAction.logEvent(TransactionType.FEATURE_DISABLED, Long.parseLong(mid), Long.parseLong(mid), "");
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.setContentType("text/plain");
		
		try {
			feaDAO.enableFeature(featureName, Boolean.valueOf(enabled));
			response.getWriter().write("Update Successful");
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write("Update Unsuccessful");
		}
		
	}
	
}
