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
pageTitle = "iTrust - Obstetrics Patient Initialization";
%>

<%@include file="/header.jsp" %> 
<itrust:patientNav thisTitle="Obstetrics Patient Initialization" />

<form name="addOBVisit" action="../hcp-uap/OBInitialization.jsp" method="post">
<table>
	<tr>
		<th>Number of Weeks Pregnant: </th>
		<td><input id="numWeeksPregVisit" name="numWeeksPregVisit" type="number" min="0" required="true"/></td>
	</tr>
	<tr>
		<th>Weight in Pounds: </th>
		<td><input id="numPounds" name="numPounds" type="number" step="any" min="0" required="true"/></td>
	</tr>
	<tr>
		<th>Blood Pressure (mm Hg): </th>
		<td><input id="bloodPressure" name="bloodPressure" type="number" min="0" required="true"/></td>
	</tr>
	<tr>
		<th>Fetal Heart Rate: </th>
		<td><input id="heartRate" name="heartRate" type="number" min="0" required="true"/></td>
	</tr>

	<tr>
		<th>Fundal Height of the Uterus: </th>
		<td><input id="fundalHeight" name="fundalHeight" type="number" step="any" min="0" required="true"/></td>
	</tr>
	<tr>
		<td><button type="submit">Add Visit</button></td>
	</tr>
</table>
</form>