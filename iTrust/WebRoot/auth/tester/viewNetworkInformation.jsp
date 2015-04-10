<%@page errorPage="/auth/exceptionHandler.jsp"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.RequestDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.RequestBean"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.ResponseDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.ResponseBean"%>
<%@page import="java.util.List"%>
<%@include file="/global.jsp"%>

<head>

<%
pageTitle = "iTrust - View Network Information";
%>

<%@include file="/header.jsp"%>

</head>

<%
	RequestDAO reqDAO = prodDAO.getRequestDAO();
	ResponseDAO resDAO = prodDAO.getResponseDAO();
%>

<body>
	
	<div style="text-align: center;">
		<h1>Network Information</h1>
		<table class="fancyTable" align="center" border="1" cellpadding="2" cellspacing="2">
			<thead>
				<th>Network Type</th>
				<th>Value</th>
			</thead>
			
			<tbody>
				<%
					//Total Number of Requests
					List<RequestBean> requests = reqDAO.getRequests();
				%>
				<tr>
					<td>Total Number of HTTP Requests</td>
					<td><%= requests.size() %></td>
				</tr>
				
				<%
					//Total Number of Responses
					List<ResponseBean> responses = resDAO.getResponses();
				%>
				<tr>
					<td>Total Number of HTTP Responses</td>
					<td><%= responses.size() %></td>
				</tr>
				
				<%
					//Total Request Body Size
					double reqSize = 0;
					for (RequestBean req : requests){
						if (req.getContentLength() != -1){
							reqSize += req.getContentLength();
						}
					}
					
					reqSize = (reqSize * (Math.pow(10.0, -6.0)));
				%>
				<tr>
					<td>Total HTTP Request Body Size (MB)</td>
					<td><%= reqSize %></td>
				</tr>
				
				<%
					//Total Response Body Size
					double resSize = new Integer(0);
					for (ResponseBean res : responses){
						resSize += res.getContentLength();
					}
					
					resSize = (resSize * (Math.pow(10.0, -6.0)));
				%>
				<tr>
					<td>Total HTTP Response Body Size (MB)</td>
					<td><%= resSize %></td>
				</tr>
				
				<tr>
					<td> Average Requests Per Day </td>
					<td><%= reqDAO.getNumRequestsPerDay() %></td>
				</tr>
				
			</tbody>
		</table>
		<div id="chart-div1"></div>
		<div id="chart-div2"></div>
	</div>
</body>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
google.load('visualization', '1.0', {'packages':['corechart']});

google.setOnLoadCallback(drawChart1);
google.setOnLoadCallback(drawChart2);

function drawChart1(){
	var data = new google.visualization.DataTable();
    data.addColumn('string', 'Type');
    data.addColumn('number', 'Body Size (bytes)');
    data.addRows([
      ['Request', <%= reqDAO.getAverageContentLength() %>],
      ['Response', <%= resDAO.getAverageContentLength() %>],
    ]);

    // Set chart options
    var options = {'title':'Average Content Length',
                   'width':1000,
                   'height':200};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.BarChart(document.getElementById('chart-div1'));
    chart.draw(data, options);
}

function drawChart2(){
	var data = new google.visualization.DataTable();
    data.addColumn('string', 'Type');
    data.addColumn('number', 'Latency (ms)');
    data.addRows([
      ['Response', <%= resDAO.getAverageLatency() %>]
    ]);

    // Set chart options
    var options = {'title':'Average Response Latency',
                   'width':1000,
                   'height':200};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.BarChart(document.getElementById('chart-div2'));
    chart.draw(data, options);
}

</script>

<%@include file="/footer.jsp"%>