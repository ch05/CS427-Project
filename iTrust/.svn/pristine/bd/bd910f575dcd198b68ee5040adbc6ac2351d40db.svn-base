DELETE FROM users WHERE MID = 57;
DELETE FROM officevisits WHERE PatientID = 57;
DELETE FROM patients WHERE MID = 57;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (57, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (57, 'Captain', 'Morgan', 'rum@man.com', '919-444-2228', 'Male', '2013-04-23', 35.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10057,'2013-02-23',9000000003,'Die in two months','1',57);


