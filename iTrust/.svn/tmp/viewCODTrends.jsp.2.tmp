<%@page errorPage="/auth/exceptionHandler.jsp" %>

<%@page import="edu.ncsu.csc.itrust.dao.mysql.PatientDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.LabProcedureBean"%>
<%@page import="edu.ncsu.csc.itrust.beans.ObstetricsBean"%>
<%@page import="edu.ncsu.csc.itrust.action.ViewMyReportRequestsAction"%>
<%@page import="edu.ncsu.csc.itrust.beans.PatientBean"%>
<%@page import="edu.ncsu.csc.itrust.action.LabProcHCPAction"%>
<%@page import="edu.ncsu.csc.itrust.beans.ReportRequestBean"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.CODTrendsDAO"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.ObstetricsDAO"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.EpidemicDAO"%>

<%@page import="java.sql.*" %>

<%@page import="java.util.List"%>

<%@include file="/global.jsp" %>

<%
pageTitle = "iTrust - View Cause of Death Trends";
%>

<%@include file="/header.jsp" %>
<%
	//Get the submitted parameters to search by
	String coverage = request.getParameter("SelectCoverage");
	String startYear = request.getParameter("StartingYear");
	String endYear = request.getParameter("EndingYear");
	
	coverage = coverage == null ? "All" : coverage;
	startYear = startYear == null ? "2014" : startYear;
	endYear = endYear == null ? "2014" : endYear;

%>	
<form>
<table class="fTable" align="center">
		<tr>
			<th colspan="3">Cause of Death Trends</th>
		</tr>
		<tr class="subHeader">
			<td>Coverage</td>
			<td>Starting Year</td>
			<td>Ending Year</td>
		</tr>
<tr>
		
<td>
		<select name="SelectCoverage">
			<option></option>
			<option value="All" <%if(coverage.equalsIgnoreCase("All")){%>selected<%}%>>All</option>
			<option value="Male" <%if(coverage.equalsIgnoreCase("Male")){%>selected<%}%>>Male</option>
			<option value="Female" <%if(coverage.equalsIgnoreCase("Female")){%>selected<%}%>>Female</option>
		</select> 
</td>
<td>
		<select name="StartingYear">
			<option></option>
			<option value="2005" <%if(startYear.equalsIgnoreCase("2005")){%>selected<%}%>>2005</option>
			<option value="2006" <%if(startYear.equalsIgnoreCase("2006")){%>selected<%}%>>2006</option>
			<option value="2007" <%if(startYear.equalsIgnoreCase("2007")){%>selected<%}%>>2007</option>
			<option value="2008" <%if(startYear.equalsIgnoreCase("2008")){%>selected<%}%>>2008</option>
			<option value="2009" <%if(startYear.equalsIgnoreCase("2009")){%>selected<%}%>>2009</option>
			<option value="2010" <%if(startYear.equalsIgnoreCase("2010")){%>selected<%}%>>2010</option>
			<option value="2011" <%if(startYear.equalsIgnoreCase("2011")){%>selected<%}%>>2011</option>
			<option value="2012" <%if(startYear.equalsIgnoreCase("2012")){%>selected<%}%>>2012</option>
			<option value="2013" <%if(startYear.equalsIgnoreCase("2013")){%>selected<%}%>>2013</option>
			<option value="2014" <%if(startYear.equalsIgnoreCase("2014")){%>selected<%}%>>2014</option>
			</select> 
		<!-- </select> <input type="submit" value="Select Starting Year" name="" startYear"" /> -->
</td>
<td>
		<select name="EndingYear">
			<option></option>
			<option value="2005" <%if(endYear.equalsIgnoreCase("2005")){%>selected<%}%>>2005</option>
			<option value="2006" <%if(endYear.equalsIgnoreCase("2006")){%>selected<%}%>>2006</option>
			<option value="2007" <%if(endYear.equalsIgnoreCase("2007")){%>selected<%}%>>2007</option>
			<option value="2008" <%if(endYear.equalsIgnoreCase("2008")){%>selected<%}%>>2008</option>
			<option value="2009" <%if(endYear.equalsIgnoreCase("2009")){%>selected<%}%>>2009</option>
			<option value="2010" <%if(endYear.equalsIgnoreCase("2010")){%>selected<%}%>>2010</option>
			<option value="2011" <%if(endYear.equalsIgnoreCase("2011")){%>selected<%}%>>2011</option>
			<option value="2012" <%if(endYear.equalsIgnoreCase("2012")){%>selected<%}%>>2012</option>
			<option value="2013" <%if(endYear.equalsIgnoreCase("2013")){%>selected<%}%>>2013</option>
			<option value="2014" <%if(endYear.equalsIgnoreCase("2014")){%>selected<%}%>>2014</option>
		<!-- </select> <input type="submit" value="Select Ending Year" name="" endYear"" /> -->
		</select> 	
</td>

<td>
<input type="submit" value="Submit" name="" submit"" />
</td>

</tr>

	</table>
	</form>
<div class="col-sm-12">
	<div class="panel panel-primary panel-notification">
	<div style="padding-bottom: 10px" class="panel-heading"><h3 class="panel-title">Cause of Death Trends For HCP Patients</h3></div>
	<div class="panel-body">
		<ul>
			<%
				
				String starty = startYear == null ? "2014" : startYear;
				String endy = endYear == null ? "2014" : endYear;
				Date start = Date.valueOf(starty + "-01-01");
				Date end = Date.valueOf(endy + "-01-01");
				String mf = coverage == null ? "All" : coverage;

				long hcpid = loggedInMID;
				CODTrendsDAO ctd = new CODTrendsDAO(DAOFactory.getProductionInstance());
				List<String> list = ctd.getTwoCommonDeathsForHCPID(hcpid, mf, start, end);
				for(int i = 0; i < list.size(); i++)
				{
					out.print("<li>" + (i+1) + ". " + list.get(i) + "</li>");
				}

			%>
		</ul>

	</div>
	
	<div class="panel-heading"><h3 class="panel-title">Cause of Death Trends For All Patients</h3></div>
	<div class="panel-body">
		<ul>
			<%
				List<String> list2 = ctd.getTwoMostCommonDeaths(mf, start, end);

				for(int i = 0; i < list2.size(); i++)
				{
					out.print("<li>" + (i+1) + ". " + list2.get(i) + "</li>");
				}
			%>
		</ul>

	</div>
</div>

</div>


<%@include file="/footer.jsp" %>