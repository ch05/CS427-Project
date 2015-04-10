DELETE FROM users WHERE MID = 51;
DELETE FROM officevisits WHERE PatientID = 51;
DELETE FROM patients WHERE MID = 51;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (51, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (51, 'Abe', 'Lincoln', 'honest@abe.com', '919-444-2222', 'Male', '2014-04-23', 84.50);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10051,'2014-02-23',9000000000,'Die in two months','1',51);


