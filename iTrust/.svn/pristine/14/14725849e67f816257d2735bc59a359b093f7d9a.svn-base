DELETE FROM users WHERE MID = 60;
DELETE FROM officevisits WHERE PatientID = 60;
DELETE FROM patients WHERE MID = 60;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (60, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (60, 'Mother', 'Theresa', 'save@earth.com', '919-444-2231', 'Female', '2014-07-04', 35.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10060,'2014-05-04',9000000003,'Die in two months','1',60);


