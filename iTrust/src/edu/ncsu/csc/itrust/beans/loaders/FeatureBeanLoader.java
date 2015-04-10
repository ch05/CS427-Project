package edu.ncsu.csc.itrust.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.beans.FeatureBean;

public class FeatureBeanLoader implements BeanLoader<FeatureBean> {

	@Override
	public List<FeatureBean> loadList(ResultSet rs) throws SQLException {
		List<FeatureBean> list = new ArrayList<FeatureBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public FeatureBean loadSingle(ResultSet rs) throws SQLException {
		FeatureBean bean = new FeatureBean();
		bean.setFeatureName(rs.getString("feature_name"));
		bean.setFilePath(rs.getString("file_path"));
		bean.setEnabled(rs.getBoolean("enabled"));
		return bean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			FeatureBean bean) throws SQLException {
		ps.setString(1, bean.getFeatureName());
		ps.setString(2, bean.getFilePath());
		ps.setBoolean(3, bean.isEnabled());
		return ps;
	}

}
