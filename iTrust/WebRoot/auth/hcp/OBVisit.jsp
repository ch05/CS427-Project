<%@taglib uri="/WEB-INF/tags.tld" prefix="itrust"%>
<%@page errorPage="/auth/exceptionHandler.jsp"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="edu.ncsu.csc.itrust.dao.DAOFactory"%>
<%@page import="edu.ncsu.csc.itrust.action.ViewHealthRecordsHistoryAction"%>
<%@page import="edu.ncsu.csc.itrust.beans.HealthRecord"%>
<%@page import="edu.ncsu.csc.itrust.BeanBuilder"%>
<%@page import="edu.ncsu.csc.itrust.beans.forms.HealthRecordForm"%>
<%@page import="edu.ncsu.csc.itrust.exception.FormValidationException"%>
<%@page import="edu.ncsu.csc.itrust.beans.PersonnelBean"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO"%>
<%@page import="edu.ncsu.csc.itrust.action.AddObstetricsPatient"%>
<%@page import="edu.ncsu.csc.itrust.enums.Gender"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.ObstetricsDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.ObstetricsBean"%>



<%@include file="/global.jsp" %>

<%
pageTitle = "iTrust - Obstetrics Patient Visit";
%>

<%@include file="/header.jsp" %> 
<itrust:patientNav thisTitle="Obstetrics Patient Initialization" />
<%

	EventLoggingAction logger = new EventLoggingAction(prodDAO);

	int numWeeksPregVisit;
	double numPounds;
	int bloodPressure;
	int heartRate;
	double fundalHeight;
	long patientMID;
	Date mostRecentDate;
	
	if(request.getParameter("numWeeksPregVisit") != null) {
		numWeeksPregVisit = Integer.parseInt(request.getParameter("numWeeksPregVisit"));
		numPounds = Double.parseDouble(request.getParameter("numPounds"));
		bloodPressure = Integer.parseInt(request.getParameter("bloodPressure"));
		heartRate = Integer.parseInt(request.getParameter("heartRate"));
		fundalHeight = Double.parseDouble(request.getParameter("fundalHeight"));
		patientMID = Integer.parseInt(request.getParameter("mid"));
		mostRecentDate = Date.valueOf(request.getParameter("date"));
		
		ObstetricsDAO obd = new ObstetricsDAO(DAOFactory.getProductionInstance());
		int initID = obd.getInitID((int)patientMID, mostRecentDate);
		ObstetricsBean ob = new ObstetricsBean(numWeeksPregVisit, numPounds, heartRate, bloodPressure, fundalHeight, patientMID, initID);
		obd.updateOBVisit((int)patientMID, mostRecentDate, ob);
		logger.logEvent(TransactionType.EDIT_OBS_VISIT, loggedInMID, patientMID, "Office Visit ID goes here");
		%>
		<font color="red">The visit has been successfully updated.</font> <%
	}
	else {
		Date date = Date.valueOf(request.getParameter("date"));
		long mid = Long.parseLong(request.getParameter("mid"));
		ObstetricsDAO obd = new ObstetricsDAO(DAOFactory.getProductionInstance());
		ObstetricsBean ob = obd.obVisitsForPatient(mid, date);
		
		numWeeksPregVisit = ob.numWeeksPregVisit;
		numPounds = ob.numPounds;
		bloodPressure = ob.bloodPressure;
		heartRate = ob.heartRate;
		fundalHeight = ob.fundalHeight;
		patientMID = mid;
		mostRecentDate = date;
	}
	
	
	logger.logEvent(TransactionType.VIEW_OBS_VISIT, loggedInMID, patientMID, "Office Visit ID goes here");
	
%>
<form name="addOBVisit" action="OBVisit.jsp" method="post">
<table>
	<tr>
		<th>Number of Weeks Pregnant: </th>
		<td><input id="numWeeksPregVisit" name="numWeeksPregVisit" type="number" min="0" required="true" value="<%= numWeeksPregVisit %>" /></td>
	</tr>
	<tr>
		<th>Weight in Pounds: </th>
		<td><input id="numPounds" name="numPounds" type="number" step="any" min="0" required="true" value="<%= numPounds %>" /></td>
	</tr>
	<tr>
		<th>Blood Pressure (mm Hg): </th>
		<td><input id="bloodPressure" name="bloodPressure" type="number" min="0"required="true" value="<%= bloodPressure %>" /></td>
	</tr>
	<tr>
		<th>Fetal Heart Rate: </th>
		<td><input id="heartRate" name="heartRate" type="number" min="0" required="true" value="<%= heartRate %>" /></td>
	</tr>

	<tr>
		<th>Fundal Height of the Uterus: </th>
		<td><input id="fundalHeight" name="fundalHeight" type="number" step="any" min="0" required="true" value="<%= fundalHeight %>" /></td>
	</tr>
	<tr>
		<td><button type="submit">Update Visit</button></td>
	</tr>
	<input type="hidden" name="date" value="<%= mostRecentDate %>"/>
	<input type="hidden" name="mid" value="<%= patientMID %>"/>
</table>
</form>
<%@include file="/footer.jsp" %>