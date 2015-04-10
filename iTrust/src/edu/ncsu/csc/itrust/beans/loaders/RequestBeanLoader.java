package edu.ncsu.csc.itrust.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.beans.RequestBean;

public class RequestBeanLoader implements BeanLoader<RequestBean> {

	@Override
	public List<RequestBean> loadList(ResultSet rs) throws SQLException {
		List<RequestBean> list = new ArrayList<RequestBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	@Override
	public RequestBean loadSingle(ResultSet rs) throws SQLException {
		RequestBean bean = new RequestBean();
		bean.setContentLength(rs.getInt("contentLength"));
		bean.setDate(rs.getTimestamp("requestDate"));
		bean.setRequestedPage(rs.getString("requestedPage"));
		bean.setHost(rs.getString("host"));
		bean.setUserAgent(rs.getString("userAgent"));
		return bean;
	}

	@Override
	public PreparedStatement loadParameters(PreparedStatement ps,
			RequestBean bean) throws SQLException {
		ps.setInt(1, bean.getContentLength());
		ps.setTimestamp(2, bean.getDate());
		ps.setString(3, bean.getRequestedPage());
		ps.setString(4, bean.getHost());
		ps.setString(5, bean.getUserAgent());
		return ps;
	}

}
