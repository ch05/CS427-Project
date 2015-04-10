DELETE FROM users WHERE MID = 55;
DELETE FROM officevisits WHERE PatientID = 55;
DELETE FROM patients WHERE MID = 55;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (55, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (55, 'Leslie', 'Knope', 'pawnee@ind.com', '919-444-2226', 'Female', '2014-04-01', 35.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10055,'2014-02-01',9000000003,'Die in two months','1',55);


