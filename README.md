# CS427-Project
Class project for CS427 in UIUC

iTrust is an open-source role-based healthcare web application.
The original codebase can be foudn on wiki for iTrust: http://agile.csc.ncsu.edu/iTrust/wiki/doku.php?id=start

Files our group modified:

httptests/edu/ncsu/csc/itrust/Team805
	UC14, UC20, UC63

src/edu/ncsu/csc/itrust/dao/mysql
	ObstetricsDAO.java
	EpidemicDAO.java
	CODTrendsDAO.java

src/edu/ncsu/csc/itrust/action
	AddObstetricsPatient.java
	AddOfficeVisitAction.java
	AddPatientAction.java

sql/data
	hcpUC63.sql

unittests/edu/ncsu/csc/itrust/datagenerators
	TestDataGenerator.java

unittests/edu/ncsu/csc/itrust/Team805/
	UC14, UC20, UC63_UC64

WebRoot/
	header.jsp
	footer.jsp

WebRoot/auth/hcp
	viewCODTrends.jsp
	OBRecord.jsp
	addOBRecord.jsp
	OBInitialization.jsp
	menu.jsp
	requestBiosurveillance.jsp

WebRoot/auth/hcp-uap
	OBInitialization.jsp
