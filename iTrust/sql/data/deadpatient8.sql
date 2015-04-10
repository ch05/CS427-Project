DELETE FROM users WHERE MID = 58;
DELETE FROM officevisits WHERE PatientID = 58;
DELETE FROM patients WHERE MID = 58;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (58, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (58, 'Rose', 'Titanic', 'ship@sinks.com', '919-444-2229', 'Female', '2013-09-14', 35.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10058,'2013-07-14',9000000000,'Die in two months','1',58);


