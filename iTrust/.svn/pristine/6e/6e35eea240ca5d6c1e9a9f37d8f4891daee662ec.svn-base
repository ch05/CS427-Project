DELETE FROM users WHERE MID = 53;
DELETE FROM officevisits WHERE PatientID = 53;
DELETE FROM patients WHERE MID = 53;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (53, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (53, 'James', 'Polk', 'polka@dot.com', '919-444-2224', 'Male', '2014-10-19', 84.50);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10053,'2014-08-19',9000000000,'Die in two months','1',53);


