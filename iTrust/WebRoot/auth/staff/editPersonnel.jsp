<%@taglib prefix="itrust" uri="/WEB-INF/tags.tld" %>
<%@page errorPage="/auth/exceptionHandler.jsp" %>

<%@page import="edu.ncsu.csc.itrust.beans.PersonnelBean"%>
<%@page import="edu.ncsu.csc.itrust.action.EditPersonnelAction"%>
<%@page import="edu.ncsu.csc.itrust.BeanBuilder"%>
<%@page import="edu.ncsu.csc.itrust.exception.FormValidationException"%>
<%@page import="edu.ncsu.csc.itrust.enums.TransactionType"%>
<%@page import="edu.ncsu.csc.itrust.enums.Role"%>

<%@include file="/global.jsp"%>

<%
pageTitle = "iTrust - Edit Personnel";
%>

<%@include file="/header.jsp"%>

<%
/* Use session variable with key "pid" */
String pidString = (String)session.getAttribute("mid");
if (null == pidString || 1 > pidString.length()) {
	//System.out.println("if branch");	
	if (null == (pidString = (String)session.getAttribute("editmid"))) {
		System.out.println("if branch 2");
		response.sendRedirect("/iTrust/auth/getPersonnelID.jsp?forward=staff/editPersonnel.jsp");
		return;
	}
}
/* else if(null != (pidString = (String)session.getAttribute("editmid"))){
	System.out.println("else if branch");
	response.sendRedirect("/iTrust/auth/getPersonnelID.jsp?forward=staff/editPersonnel.jsp");
	return;
} */
else {
	//System.out.println("else branch");
	request.setAttribute("mid", pidString);
	session.removeAttribute("mid");	
	session.setAttribute("editmid", pidString);	
	//System.out.println("editmid, end of else");
}
	//System.out.println("continue");
/* A bad personnel ID gets you exiled to the exception handler */
EditPersonnelAction personnelEditor = new EditPersonnelAction(prodDAO, loggedInMID.longValue(), pidString);
long pid  = personnelEditor.getPid();
	
/* Now take care of updating information */
boolean formIsFilled = (null != request.getParameter("formIsFilled")) && request.getParameter("formIsFilled").equals("true");
PersonnelBean personnelForm;
if (formIsFilled) {
	personnelForm = new BeanBuilder<PersonnelBean>().build(request.getParameterMap(), new PersonnelBean());
	try {
		personnelEditor.updateInformation(personnelForm);
		if(personnelForm.getRole() == Role.HCP) // If pid belongs to an HCP
			loggingAction.logEvent(TransactionType.LHCP_EDIT, loggedInMID.longValue(), personnelForm.getMID(), "");
		else if(personnelForm.getRole() == Role.UAP) // If pid belongs to a UAP
			loggingAction.logEvent(TransactionType.UAP_EDIT, loggedInMID.longValue(), personnelForm.getMID(), "");
		else if(personnelForm.getRole() == Role.ER) // If pid belongs to a ER
			loggingAction.logEvent(TransactionType.ER_EDIT, loggedInMID.longValue(), personnelForm.getMID(), "");
		else if(personnelForm.getRole() == Role.PHA) // If pid belongs to a PHA
			loggingAction.logEvent(TransactionType.PHA_EDIT, loggedInMID.longValue(), personnelForm.getMID(), "");
		else if(personnelForm.getRole() == Role.LT) // If pid belongs to a LT
			loggingAction.logEvent(TransactionType.LT_EDIT, loggedInMID.longValue(), personnelForm.getMID(), "");
		//Change the value so that the next time "Edit Personnel" is clicked, the page will be redirected to getPersonnelID.jsp
		session.removeAttribute("editmid");
		//System.out.println("II IF");
%>		
		<div align=center>
			<span class="iTrustMessage">Information Successfully Updated</span>
		</div>
<%
	} catch(FormValidationException e) {
%>
		<div align=center>
			<span class="iTrustError"><% e.printHTML(pageContext.getOut()); %></span>
		</div>
<%
	personnelForm = prodDAO.getPersonnelDAO().getPersonnel(pid);
	}
}
else {
	personnelForm = prodDAO.getPersonnelDAO().getPersonnel(pid);
//	System.out.println("II ELSE");
}
loggingAction.logEvent(TransactionType.PERSONNEL_VIEW, loggedInMID.longValue(), personnelForm.getMID(), "");
//System.out.println("end");
/* if((null == (pidString = (String)session.getAttribute("editmid")){
	session.removeAttribute("editmid");
}
 */%>
<br>

<form action="editPersonnel.jsp" method="post">
<input type="hidden" name="formIsFilled" value="true">
<input type="hidden" name="roleString" value="<%=personnelForm.getRole() %>" />
<div align=center>
	<table class="fTable" align=center>
	<tr>
		<th colspan=2 >Personnel Information</th>
	</tr>
	<tr>
		<td class="subHeaderVertical">
		  First Name:
		</td><td>
		  <input name="firstName"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getFirstName())) %>"  type="text">
	      </td></tr>
	      <tr><td class="subHeaderVertical">
		 Last Name:
		</td><td>

		  <input name="lastName"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getLastName())) %>"  type="text">
	      </td></tr>
	      <tr><td class="subHeaderVertical">
		  Address:
		</td><td>

		  <input name="streetAddress1"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getStreetAddress1())) %>"  type="text"><br />
		  <input name="streetAddress2"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getStreetAddress2())) %>"  type="text">
	      </td></tr>
	      <tr ><td class="subHeaderVertical">
		  City:
		</td><td>
		  <input name="city"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getCity())) %>"  type="text">
	      </td></tr>
	      <tr><td class="subHeaderVertical">

		  State:
		</td><td>
			<itrust:state name="state" value="<%= StringEscapeUtils.escapeHtml(personnelForm.getState()) %>"/>
	      </td></tr>
	      <tr ><td class="subHeaderVertical">
		  Zip:
		</td><td>
		  <input name="zip" value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getZip())) %>"  maxlength="10" type="text" size="10">
	      </td></tr>
	      <tr ><td class="subHeaderVertical">

		  Phone:
		</td><td>
		  <input name="phone"  value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getPhone())) %>"  type="text" size="12" maxlength="12">
	      </td></tr>
		  <tr>
		  	<td class="subHeaderVertical">Email:</td>
		  	<td><input name="email" value="<%= StringEscapeUtils.escapeHtml("" + (personnelForm.getEmail())) %>" type="text"></td>
		  </tr>
		      
		    </table>
		  </td></tr>
		  <tr>
		  	<td colspan=2>
		  		<br />
		      <input type="submit" name="action" style="font-size: 16pt; font-weight: bold;" value="Edit Personnel Record">
		  	</td>
		  </tr>
      </table>
     </div>
</form>
<div align=center>
	<br />
	<span style="font-size: 14px;">
		Note: in order to set the password for this user, use the "Reset Password" link at the login page.
	</span>
	<br />
</div>


<%@include file="/footer.jsp" %>
