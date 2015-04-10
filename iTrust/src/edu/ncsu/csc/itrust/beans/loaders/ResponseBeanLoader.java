package edu.ncsu.csc.itrust.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.beans.ResponseBean;

public class ResponseBeanLoader implements BeanLoader<ResponseBean> {

	@Override
	public List<ResponseBean> loadList(ResultSet rs) throws SQLException {
		List<ResponseBean> list = new ArrayList<ResponseBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public ResponseBean loadSingle(ResultSet rs) throws SQLException {
		ResponseBean bean = new ResponseBean();
		bean.setContentLength(rs.getInt("content_length"));
		bean.setDate(rs.getTimestamp("create_date"));
		bean.setRequestedPage(rs.getString("requested_page"));
		bean.setLatency(rs.getDouble("latency"));
		return bean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			ResponseBean bean) throws SQLException {
		ps.setInt(1, bean.getContentLength());
		ps.setTimestamp(2, bean.getDate());
		ps.setString(3, bean.getRequestedPage());
		ps.setDouble(4, bean.getLatency());
		return ps;
	}

}
