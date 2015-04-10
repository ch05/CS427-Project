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

<form name="addOBRecord" action="../hcp-uap/OBInitialization.jsp" method="post">
<table>
	<tr>
		<th>Last Menstrual Period: </th>
		<td><input id="lmp" name="lmp" type="textbox"/></td>
	</tr>
	<tr>
		<th>Year of Conception: </th>
		<td><input id="yoc" name="yoc" type="textbox"/></td>
	</tr>
	<tr>
		<th>Number of Weeks Pregnant: </th>
		<td><input id="numWeeksPreg" name="numWeeksPreg" type="textbox"/></td>
	</tr>
	<tr>
		<th>Number of Hours In Labor: </th>
		<td><input id="numHoursLabor" name="numHoursLabor" type="textbox"/></td>
	</tr>

	<tr>
		<th>Delivery Type: </th>
		<td>
			<select name="dt">
				<option value="Caesarean Section">Caesarean Section</option>
				<option value="Miscarriage">Miscarriage</option>
				<option value="Vaginal Delivery">Vaginal Delivery</option>	
			</select>
		</td>
	</tr>
	<tr>
		<td><button type="submit">Add Record</button></td>
	</tr>
</table>
</form>