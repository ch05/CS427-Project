DELETE FROM users WHERE MID = 54;
DELETE FROM officevisits WHERE PatientID = 54;
DELETE FROM patients WHERE MID = 54;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (54, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (54, 'Teddy', 'Roosevelt', 'teddy@bear.com', '919-444-2225', 'Male', '2014-10-20', 72.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10054,'2014-10-20',9000000000,'Die in two months','1',54);


