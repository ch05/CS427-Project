package edu.ncsu.csc.itrust.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ncsu.csc.itrust.beans.ResponseBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.ResponseDAO;
import edu.ncsu.csc.itrust.exception.DBException;


public class ResponseTrackerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * ResponseTrackerServlet
	 * 
	 * Servlet is used for ajax requests log http response information.
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/plain");
		
		if (request.getParameter("resID") != null && request.getParameter("contentLength") != null){
			
			int resID = Integer.parseInt(request.getParameter("resID"));
			int contentLength = Integer.parseInt(request.getParameter("contentLength"));
			
			DAOFactory factory = DAOFactory.getProductionInstance();
			ResponseDAO resdao = factory.getResponseDAO();
			
			ResponseBean rbean = new ResponseBean();
			rbean.setContentLength(contentLength);
			
			try {
				resdao.updateContentLength(rbean, resID);
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.getWriter().write("Update Failed");
				
				return;
			}
			
			response.getWriter().write("Update Successful");
			
			return;
		}
		
		response.getWriter().write("Update Failed");
		
		return;
	}
	
}
