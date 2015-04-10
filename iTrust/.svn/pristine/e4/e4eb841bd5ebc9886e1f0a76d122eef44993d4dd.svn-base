<%@page import="edu.ncsu.csc.itrust.enums.TransactionType"%>
<%@page import="edu.ncsu.csc.itrust.enums.Role"%>
<%@page import="edu.ncsu.csc.itrust.dao.DAOFactory"%>
<%@page import="java.util.List"%>
<%@page import="edu.ncsu.csc.itrust.beans.TransactionBean"%>
<%@page import="edu.ncsu.csc.itrust.beans.PersonnelBean"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>


<script type="text/javascript">
$('#date').change(function(){
   selection = $(this).val();    
   switch(selection)
   { 
       case 'Select Date':
           $('#selectDate').show();
           break;
       default:
           $('#selectDate').hide();
           break;
   }
});
</script>




<html>
<%@include file="/global.jsp"%>

<head>
<title>FOR TESTING PURPOSES ONLY</title>
<%@include file="/header.jsp"%>

</head>
<body>
<% 


	String msg = "";
	String role1 = "";
	String role2 = "";
	String role1_print = "";
	String role2_print = "";
	String date = "";
	String transaction = "";
	String startDate = "";
	String endDate = "";
	Date start =new Date();
	Date end = new Date();
	boolean check_print;
	boolean first_role_check;
	boolean second_role_check;
	boolean start_check;
	boolean end_check;
	boolean trans_check;
	
	if (request.getParameter("request") != null) {
		role1 = request.getParameter("role1");
		role2 = request.getParameter("role2");
		date = request.getParameter("date");
		transaction = request.getParameter("transaction");
		
		startDate = request.getParameter("startDate");
		endDate = request.getParameter("endDate");
		if(date.equals("ALL")&&(!startDate.equals(""))||(!endDate.equals("")))
			date = "Select Date";
		
		if (date.equals("Select Date")){
			try {
				SimpleDateFormat frmt = new SimpleDateFormat(
						"MM/dd/yyyy");
				//startDate = request.getParameter("startDate");
				//endDate = request.getParameter("endDate");
				if(!startDate.equals(""))
					start = frmt.parse(startDate);
				if(!endDate.equals(""))
					end = frmt.parse(endDate);
				
				
					
			} catch (ParseException e) {
				msg = "ERROR: Date must by in the format: MM/dd/yyyy";
			}	
		}
	}
	
	if (msg.contains("ERROR")) {
%>
<span class="iTrustError"><%=msg%></span>
<%
	} else {
%>
<span class="iTrustMessage"><%=msg%></span>
<%
	}
%>
<form action="transactionLog.jsp" method="post">
<table class="fTable">
	<tr>
		<td>Role1:</td>
		<td><select name="role1">
		<option value="ALL">ALL</option>
		<%
			for (Role r : Role.values()) {
		%><option
			<%if (r.name().equals(role1))
					out.println("selected");%>
			value="<%=r.name()%>"><%=r.name()%></option>
		<%
			}
		%>
		</select></td>
	</tr>
	<tr>
		<td>Role2:</td>
		<td><select name="role2">
		<option value="ALL">ALL</option>
		<%
			for (Role r : Role.values()) {
		%><option
			<%if (r.name().equals(role2))
					out.println("selected");%>
			value="<%=r.name()%>"><%=r.name()%></option>
		<%
			}
		%>
		</select></td>
	</tr>
	<tr>
		<td>Date:</td>
		<td><select name="date" id="date">
		<option value="ALL">ALL</option>
		<option
		<% if (date.equals("Select Date"))
			out.println("selected");%>
		value="<%="Select Date"%>">Select Date</option>
	</tr>
	<div id="selectDate" style="display:none;">
	<tr>
	<td>
		<p>Start Date:</p>
		<input name="startDate"
		value="<%=StringEscapeUtils.escapeHtml("" + (startDate))%>" size="10"></td>
	<td><input type=button value="Select Date"
		onclick="displayDatePicker('startDate');"></td>
	</tr>
	<tr>
	<td>
		<p>End Date:</p>
		<input name="endDate"
		value="<%=StringEscapeUtils.escapeHtml("" + (endDate))%>" size="10"></td>
	<td><input type=button value="Select Date"
		onclick="displayDatePicker('endDate');"></td>
	</tr>
	</div>
	<tr>
		<td>Transaction:</td>
		<td><select name="transaction">
		<option value="ALL">ALL</option>
		<%
			for (TransactionType t : TransactionType.values()) {
		%><option
			<%if (t.name().equals(transaction))
					out.println("selected");%>
			value="<%=t.name()%>"><%=t.getDescription()%></option>
		<%
			}
		%>
	</tr>
</table>
<input type="submit" name="request" style="font-size: 16pt; font-weight: bold;" value="View">
<input type="submit" name="request" style="font-size: 16pt; font-weight: bold;" value="Summarize">
</form>


<table border=1>
	<tr>
		<th>First Role</th>
		<th>Second Role</th>
		<th>Transaction Name</th>
		<th>Additional Information</th>
		<th>Time Stamp</th>
		
	</tr>
	<%
		
		List<TransactionBean> list = DAOFactory.getProductionInstance().getTransactionDAO().getAllTransactions();
		
		
		for (TransactionBean t : list) {
	%>
	<tr>
		<%
			while(true){
				if(((t.getLoggedInMID()/100000000)>=10)&&((t.getLoggedInMID()/100000000)<91)){
					PersonnelBean pdao =DAOFactory.getProductionInstance().getPersonnelDAO().getPersonnel(t.getLoggedInMID());
					//out.println(pdao.getRole());
					role1_print = pdao.getRoleString().toUpperCase();
					if(pdao.getRoleString().toUpperCase().equals(role1))
						first_role_check = true;
					else 
						first_role_check = false;
					break;
				}
				else if((t.getLoggedInMID()<10000)&&(t.getLoggedInMID()>0)){
					role1_print = "PATIENT";
					if(role1.equals("PATIENT"))
						first_role_check = true;
					else
						first_role_check = false;
					break;
				} 
				else {
					role1_print = "TESTER";
					if(role1.equals("TESTER"))
						first_role_check = true;
					else 
						first_role_check = false;
					break;
				}
			}
			//out.println(role1_print);
		
		while(true){
			if(((t.getSecondaryMID()/100000000)>=10)&&((t.getSecondaryMID()/100000000)<91)){
				PersonnelBean pdao =DAOFactory.getProductionInstance().getPersonnelDAO().getPersonnel(t.getSecondaryMID());
				//out.println(pdao.getRole());
				role2_print = pdao.getRoleString().toUpperCase();
				if(pdao.getRoleString().toUpperCase().equals(role2))
					second_role_check = true;
				else 
					second_role_check = false;
				break;
			}
			else if((t.getSecondaryMID()<10000)&&(t.getSecondaryMID()>0)){
				role2_print = "PATIENT";
				if(role2.equals("PATIENT"))
					second_role_check = true;
				else
					second_role_check = false;
				break;
			} 
			else if(t.getSecondaryMID()==0){
				role2_print = "ADMIN";
				if(role2.equals("ADMIN"))
					second_role_check = true;
				else
					second_role_check = false;
				break;
			}
			else {
				role2_print = "TESETER";
				if(role2.equals("TESTER"))
					second_role_check = true;
				else 
					second_role_check = false;
				break;
			}
		}
			//out.println(first_role_check&&second_role_check);	
		%>
		
		<% 
			
			//out.println(startDate);
			//out.println(end);
			if(start.before(t.getTimeLogged()) && end.after(t.getTimeLogged()) && date.equals("Select Date"))
				check_print=true;
			else if (!date.equals("Select Date"))
				check_print = true;
			else if(startDate.equals("")&&end.after(t.getTimeLogged()))
				check_print = true;
			else if(start.before(t.getTimeLogged())&&endDate.equals(""))
				check_print = true;
			else 
				check_print= false;
			
		%>
		<% 
			if(transaction.equals("ALL"))
				trans_check = true;
			else if(transaction.equals(t.getTransactionType().name()))
				trans_check = true;
			else 
				trans_check = false;
		%>
		<% 
		if(role1.equalsIgnoreCase("ALL")) first_role_check = true;
		if(role2.equalsIgnoreCase("ALL")) second_role_check = true;
		//out.println(first_role_check);
		//out.println(second_role_check);
		
		if(check_print&&first_role_check&&second_role_check&&trans_check==true) { %>
		
		<td><%= StringEscapeUtils.escapeHtml(role1_print) %></td>
		<td><%= StringEscapeUtils.escapeHtml(role2_print) %></td>
		<td><%= StringEscapeUtils.escapeHtml("" + (t.getTransactionType().name())) %></td>	
		<td><%= StringEscapeUtils.escapeHtml("" + (t.getAddedInfo())) %></td>
		<td><%= StringEscapeUtils.escapeHtml("" + (t.getTimeLogged())) %></td>
		<% }
		%>
	</tr>
	<%
	}
	%>
</table>


<h1><a href="/iTrust">Back to iTrust</a></h1>
<h1>Transaction Code Reference</h1>
<a name="transactioncodes"></a>
List is automatically generated from the <code>edu.ncsu.csc.itrust.enums.TransactionType</code> enum.
<table border=1>
<tbody>
<tr>
<th>Type</th>
<th>Code</th>
<th>Description</th>
</tr>
<%
for(TransactionType type : TransactionType.values()){
	%><tr><td><%=type.name()%></td><%
	%><td><%=type.getCode()%></td><%
	%><td><%=type.getDescription()%></td></tr><%
}
%>
</tbody>
</table>
<h1><a href="/iTrust">Back to iTrust</a></h1>
</body>
</html>
<%@include file="/footer.jsp" %>