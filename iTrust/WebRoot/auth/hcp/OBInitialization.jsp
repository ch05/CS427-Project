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
<%

//Check if the input pid is valid
String pidString = (String)session.getAttribute("pid");
if (pidString == null || 1 > pidString.length()) {
	response.sendRedirect("/iTrust/auth/getPatientID.jsp?forward=hcp-uap/OBInitialization.jsp");
   	return;
}

AddObstetricsPatient action = new AddObstetricsPatient(prodDAO,
		loggedInMID.longValue(), pidString);



//Get the gender of the patient
Gender gender = action.getGender();
//Get the specialty of the doctor
String specialty = action.getSpecialty();

if( (gender == gender.Male) || (gender == gender.NotSpecified)){
	%>
	<p style="font-size:20px"><i>The patient is not eligible for obstetric care</i></p>
	<%
}

else if(gender == gender.Female){
	%>
	<p style="font-size:20px"><i>FEMALE</i></p>	
	Patient Initialization Records
	<ul style="list-style-type: none">
		<%
			ObstetricsDAO obd = new ObstetricsDAO(DAOFactory.getProductionInstance());
			if(request.getParameter("yoc") != null)
			{
				int yoc = Integer.parseInt(request.getParameter("yoc").replace("\"", ""));
				String numpreg = request.getParameter("numWeeksPreg");
				double numlabor = Double.parseDouble(request.getParameter("numHoursLabor").replace("\"", ""));
				String delivType = request.getParameter("dt");
				Date lmp = Date.valueOf(request.getParameter("lmp").replace("\"", ""));
				long mid = action.getPatient().getMID();
				ObstetricsBean ob = new ObstetricsBean(yoc, numpreg, numlabor, delivType, lmp, mid);
				obd.insertOBRecord(ob);
			}
			List<Date> dates = obd.obDateForPatient(action.getPatient().getMID());
			for(int i = 0; i < dates.size(); i++){
				out.print("<li><a href=\"../hcp/OBRecord.jsp?date=" + dates.get(i) + "&mid=" + action.getPatient().getMID() + "\">" + dates.get(i) + "</a></li>");
			}
		%>
	</ul>
	<%
	if(specialty.equals("OB/GYN") || true){		
		%><a href="/iTrust/auth/hcp/addOBRecord.jsp">
   		<button>Add</button>
		</a><%
	}
	
	%>
	<br><br><br>
	Office Visits
	<br>
	
	<ul style="list-style-type: none">
	<%
	if(request.getParameter("numWeeksPregVisit") != null)
	{
		int numWeeksPregVisit = Integer.parseInt(request.getParameter("numWeeksPregVisit"));
		double numPounds = Double.parseDouble(request.getParameter("numPounds"));
		int bloodPressure = Integer.parseInt(request.getParameter("bloodPressure"));
		int heartRate = Integer.parseInt(request.getParameter("heartRate"));
		double fundalHeight = Double.parseDouble(request.getParameter("fundalHeight"));
		long patientMID = action.getPatient().getMID();
		Date mostRecentDate = dates.get(0);
		
		int initID = obd.getInitID((int)patientMID, mostRecentDate);
		
		ObstetricsBean ob2 = new ObstetricsBean(numWeeksPregVisit, numPounds, heartRate, bloodPressure, fundalHeight, (int)patientMID, initID);
		obd.insertOBVisit(ob2);
		EventLoggingAction logger = new EventLoggingAction(prodDAO);
		logger.logEvent(TransactionType.CREATE_OBS_VISIT, loggedInMID, action.getPatient().getMID(), "Office Visit ID goes here");
	}
	List<Date> visitDates = obd.obPatientVisitDate(action.getPatient().getMID());
	for(int i = 0; i < visitDates.size(); i++){
		out.print("<li><a href=\"../hcp/OBVisit.jsp?date=" + visitDates.get(i) + "&mid=" + action.getPatient().getMID() + "\">" + visitDates.get(i) + "</a></li>");
	}
	
	if (dates.size() > 0){
		Date lmp = obd.obRecordsForPatient(action.getPatient().getMID(), dates.get(0)).LMP;
		Calendar cal = Calendar.getInstance();
		cal.setTime(lmp);
		cal.add(Calendar.DATE, 343);
		
		Calendar today = Calendar.getInstance();
		today.setTime(new java.util.Date());
		if (cal.compareTo(today) < 0){
			%>
			</ul>
			<a href="/iTrust/auth/hcp/addOBVisit.jsp">
		   		<button>Add</button>
				</a>
			<%
		}
		else{
			%>
			</ul>
			
		   		<p>No initial visits</p>
				
			<%
		}
	}
	else{
		%>
		</ul>
		
	   		<p>LMP is greater than 49 weeks</p>
			
		<%
	}
	
	
}

%>
<%@include file="/footer.jsp" %>
