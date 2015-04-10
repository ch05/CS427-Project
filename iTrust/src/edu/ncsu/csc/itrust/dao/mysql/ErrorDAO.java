package edu.ncsu.csc.itrust.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ncsu.csc.itrust.DBUtil;
import edu.ncsu.csc.itrust.beans.ErrorBean;
import edu.ncsu.csc.itrust.beans.loaders.ErrorBeanLoader;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.exception.DBException;

/**
 * Used for logging application errors.
 * 
 * DAO stands for Database Access Object. All DAOs are intended to be reflections of the database, that is,
 * one DAO per table in the database (most of the time). For more complex sets of queries, extra DAOs are
 * added. DAOs can assume that all data has been validated and is correct.
 * 
 * DAOs should never have setters or any other parameter to the constructor than a factory. All DAOs should be
 * accessed by DAOFactory (@see {@link DAOFactory}) and every DAO should have a factory - for obtaining JDBC
 * connections and/or accessing other DAOs.
 * 
 *  
 * 
 */
public class ErrorDAO {
	private DAOFactory factory;
	private ErrorBeanLoader errLoader;
	/**
	 * The typical constructor.
	 * @param factory The {@link DAOFactory} associated with this DAO, which is used for obtaining SQL connections, etc.
	 */
	public ErrorDAO(DAOFactory factory) {
		this.factory = factory;
		this.errLoader = new ErrorBeanLoader();
	}
	
	/**
	 * Adds a new entry in the error table.
	 * 
	 * @param error - The ErrorBean object
	 * @throws DBException
	 */
	public void addError(ErrorBean error) throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("INSERT INTO error (user_id, message, requested_page) VALUES (?, ?, ?)");
			ps.setLong(1, error.getMid());
			ps.setString(2, error.getMessage());
			ps.setString(3, error.getRequestedPage());
			ps.execute();
			
			ps.close();
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	/**
	 * Returns a list of all the errors in the error table.
	 * 
	 * @return - List of ErrorBean objects
	 * @throws DBException
	 */
	public List<ErrorBean> getErrors() throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM error");
			ResultSet rs = ps.executeQuery();
			List<ErrorBean> errors = errLoader.loadList(rs);
			rs.close();
			ps.close();
			
			return errors;
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
}