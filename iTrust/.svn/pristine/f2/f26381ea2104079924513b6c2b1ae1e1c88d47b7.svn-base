DELETE FROM users WHERE MID = 59;
DELETE FROM officevisits WHERE PatientID = 59;
DELETE FROM patients WHERE MID = 59;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (59, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (59, 'Jackie', 'Chan', 'kung@fu.com', '919-444-2230', 'Male', '2012-05-05', 35.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10059,'2012-03-05',9000000003,'Die in two months','1',59);


