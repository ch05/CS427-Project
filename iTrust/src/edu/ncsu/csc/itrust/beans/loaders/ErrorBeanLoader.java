package edu.ncsu.csc.itrust.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.beans.ErrorBean;

public class ErrorBeanLoader implements BeanLoader<ErrorBean> {

	@Override
	public List<ErrorBean> loadList(ResultSet rs) throws SQLException {
		List<ErrorBean> list = new ArrayList<ErrorBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public ErrorBean loadSingle(ResultSet rs) throws SQLException {
		ErrorBean bean = new ErrorBean();
		bean.setMessage(rs.getString("message"));
		bean.setMid(rs.getLong("user_id"));
		bean.setRequestedPage(rs.getString("requested_page"));
		bean.setTimestamp(rs.getTimestamp("create_date"));
		return bean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			ErrorBean bean) throws SQLException {
		ps.setInt(1, (int)bean.getMid());
		ps.setString(2, bean.getRequestedPage());
		ps.setString(3, bean.getMessage());
		return ps;
	}

}