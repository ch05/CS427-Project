<%@page import="edu.ncsu.csc.itrust.dao.DAOFactory"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.ResponseDAO"%>
<%@page import="edu.ncsu.csc.itrust.dao.mysql.RequestDAO"%>
<%@page import="edu.ncsu.csc.itrust.beans.ResponseBean"%>
<%@page import="edu.ncsu.csc.itrust.beans.RequestBean"%>
				</div>
		</div>

	
		<div id="iTrustFooter" class="col-sm-8 col-sm-offset-4 col-md-9 col-md-offset-3">
			<div style="float: left; width: 48%;" class="adminLinks">
<%
			if( ! "true".equals(System.getProperty("itrust.production") ) ) { 
%>
				  <a class="iTrustTestNavlink" href="/iTrust/util/andystestutil.jsp">Test Data Generator</a>
				| <a class="iTrustTestNavlink" href="/iTrust/util/transactionLog.jsp">Transaction Log</a>
				| <a class="iTrustTestNavlink" href="/iTrust/util/displayDatabase.jsp">Display Database</a>
				| <a class="iTrustTestNavlink" href="/iTrust/util/blackbox/blackbox.jsp">Black Box Test Plan</a>
				| <a class="iTrustTestNavlink" href="/iTrust/util/showFakeEmails.jsp">Show Fake Emails</a>
<%
			}
%>
			</div>
			<div style="float: right; width: 48%; margin-right: 10px;text-align:right;">
				  <a class="iTrustNavlink" href="mailto:nobody@itrust.com">Contact</a>
				| <a class="iTrustNavlink" href="/iTrust/privacyPolicy.jsp">Privacy Policy</a>
				| <a class="iTrustNavlink" href="http://agile.csc.ncsu.edu/iTrust/">iTrust v18.0</a>
			</div>
		</div>
</div>
    <script src="/iTrust/js/bootstrap.js"></script>
	</body>
	
	<%
		// Add response
		long endLatency = System.currentTimeMillis();
		long latency = endLatency - startLatency;
		ResponseDAO resdao = new ResponseDAO(factory);
		ResponseBean rbean = new ResponseBean();
		rbean.setLatency((double)latency);
		rbean.setRequestedPage(request.getRequestURI());
		int lastID = resdao.addResponse(rbean);
		
		// Add request
		RequestBean requestBean = new RequestBean();
		requestBean.setRequestedPage(request.getRequestURI());
		requestBean.setContentLength(request.getContentLength());
		requestBean.setUserAgent(request.getHeader("user-agent"));
		requestBean.setHost(request.getHeader("host"));
		
		RequestDAO requestDAO = new RequestDAO(factory);
		requestDAO.addRequest(requestBean);
		
	%>
	<script>
		$(document).ready(function(){
			<%
			out.println("var resID = " + lastID + ";");
			%>
			
			var contentLength = document.documentElement.innerHTML.length;
			
			$.ajax({
				url: '/iTrust/ResponseTrackerServlet',
				type: 'GET',
				data: {
					'resID': resID,
					'contentLength': contentLength
				},
				success: function(response){
					console.log(response);
				}
			});
		});
	</script>
</html>
