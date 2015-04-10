DELETE FROM users WHERE MID = 52;
DELETE FROM officevisits WHERE PatientID = 52;
DELETE FROM patients WHERE MID = 52;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (52, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (52, 'George', 'Washington', 'cherry@tree.com', '919-444-2223', 'Male', '2014-09-14', 84.50);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10052,'2014-07-14',9000000000,'Die in two months','1',52);


