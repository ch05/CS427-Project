<%@page errorPage="/auth/exceptionHandler.jsp"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.ErrorDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.ErrorBean"%>
<%@page import="java.util.List"%>
<%@include file="/global.jsp"%>

<head>

<%
pageTitle = "iTrust - View Errors";
%>

<%@include file="/header.jsp"%>

</head>

<%
	List<ErrorBean> errors = errdao.getErrors();
%>

<body>
	
	<div style="text-align: center;">
		<h1>Error List</h1>
		<table class="fancyTable" align="center" border="1" cellpadding="2" cellspacing="2">
			<thead>
				<th>Date</th>
				<th>MID</th>
				<th>Requested Page</th>
				<th>Error Message</th>
			</thead>
			
			<tbody>
				<%
					for (ErrorBean err : errors){
						%>
							<tr>
								<td><%= err.getTimestamp().toString() %></td>
								<td><%= err.getMid() %></td>
								<td><%= err.getRequestedPage() %></td>
								<td><%= err.getMessage() %></td>
							</tr>
						<%
					}
				
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@include file="/footer.jsp"%>