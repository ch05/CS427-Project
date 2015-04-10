DELETE FROM users WHERE MID = 56;
DELETE FROM officevisits WHERE PatientID = 56;
DELETE FROM patients WHERE MID = 56;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) 
			VALUES (56, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'patient', 'am i dead?', 'yes');
/*password: pw*/
INSERT INTO patients (MID, firstName,lastName, email, phone, Gender, DateOfDeath, CauseOfDeath) 
VALUES (56, 'Amelia', 'Earhardt', 'flying@far.com', '919-444-2227', 'Female', '2014-07-04', 72.00);


INSERT INTO officevisits(id,visitDate,HCPID,notes,HospitalID,PatientID)
VALUES (10056,'2014-05-04',9000000003,'Die in two months','1',56);


