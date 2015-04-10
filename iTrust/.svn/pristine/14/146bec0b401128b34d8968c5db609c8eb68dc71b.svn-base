<%@taglib prefix="itrust" uri="/WEB-INF/tags.tld"%>
<%@page errorPage="/auth/exceptionHandler.jsp"%>
<%@page import="edu.ncsu.csc.itrust.beans.PersonnelBean"%>
<%@page import="edu.ncsu.csc.itrust.BeanBuilder"%>
<%@page import="edu.ncsu.csc.itrust.exception.FormValidationException"%>
<%@page import="edu.ncsu.csc.itrust.action.AddHCPAction"%>
<%@page import="edu.ncsu.csc.itrust.action.SendReminder"%>
<%@page import="edu.ncsu.csc.itrust.enums.Role"%>


<%@include file="/global.jsp" %>

<%
pageTitle = "iTrust - Send Reminder";
%>

<%@include file="/header.jsp" %>

<%
	boolean formIsFilled = request.getParameter("numDays") != null;

	if (formIsFilled) {
		//This page is not actually a "page", it just adds a user and forwards.
		int numDays = Integer.parseInt(request.getParameter("numDays"));
		SendReminder reminder = new SendReminder(prodDAO);
		reminder.send(numDays);
	}
%>

<div class="page-header"><h1>Send Reminder Messages</h1></div>
<p style=" text-align:left;">Please enter the number of days in advance to send a reminder message to 
each patient with any upcoming appointment.</p>

<form action="sendReminder.jsp" method="post">
<input type="number" name="numDays" min="1" required="true"><br />
<br />
<input type="submit" style="font-size: 16pt; font-weight: bold;" value="Send Appointment Reminder">
<br />
</form>

<%@include file="/footer.jsp" %>
