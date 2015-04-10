package edu.ncsu.csc.itrust.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ncsu.csc.itrust.DBUtil;
import edu.ncsu.csc.itrust.beans.FeatureBean;
import edu.ncsu.csc.itrust.beans.loaders.FeatureBeanLoader;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.exception.DBException;

/**
 * Used for the logging mechanism.
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
public class FeatureDAO {
	private DAOFactory factory;
	private FeatureBeanLoader fbLoader; 
	/**
	 * The typical constructor.
	 * @param factory The {@link DAOFactory} associated with this DAO, which is used for obtaining SQL connections, etc.
	 */
	public FeatureDAO(DAOFactory factory) {
		this.factory = factory;
		this.fbLoader = new FeatureBeanLoader();
	}
	
	/**
	 * Returns a list of all the features in the features table.
	 * 
	 * @return List of FeatureBean objects
	 * @throws DBException
	 */
	public List<FeatureBean> getFeatures() throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("SELECT * FROM features");
			ResultSet rs = ps.executeQuery();
			
			List<FeatureBean> features = fbLoader.loadList(rs);
			rs.close();
			ps.close();
			
			return features;
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	/**
	 * Adds a new feature to the database given a unique feature name, file path, and whether the feature is enabled.
	 * 
	 * @param featureName - Unique name for the feature
	 * @param filePath - The uri associated with the feature (the corresponding jsp file)
	 * @param enable - Whether the feature should be enabled or disabled
	 * @throws DBException
	 */
	public void addFeature(String featureName, String filePath, boolean enable) throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("INSERT INTO features (feature_name, file_path, enabled) VALUES (?, ?, ?)");
			ps.setString(1, featureName);
			ps.setString(2, filePath);
			ps.setBoolean(3, enable);
			ps.execute();
			
			ps.close();
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	/**
	 * Updates the filePath entry in the features table for a given feature.
	 * 
	 * @param featureName - Unique name of the feature
	 * @param filePath - The new file path (uri) for the feature
	 * @throws DBException
	 */
	public void updateFilePath(String featureName, String filePath) throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("UPDATE features SET file_path=? WHERE feature_name=?");
			ps.setString(1, filePath);
			ps.setString(2, featureName);
			ps.execute();
			
			ps.close();
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	/**
	 * Sets whether the feature is enabled or disabled.
	 * 
	 * @param featureName - The unique name of the feature
	 * @param enable - Boolean indicating whether to enable or disable the feature
	 * @throws DBException
	 */
	public void enableFeature(String featureName, boolean enable) throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("UPDATE features SET enabled=? WHERE feature_name=?");
			ps.setBoolean(1, enable);
			ps.setString(2, featureName);
			ps.execute();
			
			ps.close();
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
	/**
	 * Removes a feature from the features table.
	 * 
	 * @param featureName - The unique name of the feature
	 * @throws DBException
	 */
	public void removeFeature(String featureName) throws DBException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = factory.getConnection();
			ps = conn.prepareStatement("DELETE FROM features WHERE feature_name=?");
			ps.setString(1, featureName);
			ps.execute();
			
			ps.close();
			
		} catch(SQLException e) {
			throw new DBException(e);
		}finally{
			DBUtil.closeConnection(conn, ps);
		}
	}
	
}