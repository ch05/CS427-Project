INSERT INTO personnel(
MID,
AMID,
role,
lastName, 
firstName, 
address1,
address2,
city,
state,
zip,
phone,
specialty,
email) 
VALUES (
9000000089,
null,
'admin',
'System',
'Reminder',
'4321 My Road St',
'PO BOX 2',
'New York',
'NY',
'10453',
'999-888-7777',
'administrator',
'System Reminder'
)  ON DUPLICATE KEY UPDATE MID = MID;

INSERT INTO users(MID, password, role, sQuestion, sAnswer) VALUES(9000000089, '30c952fab122c3f9759f02a6d95c3758b246b4fee239957b2d4fee46e26170c4', 'admin', 'first letter?', 'a')
 ON DUPLICATE KEY UPDATE MID = MID;
 /*password: pw*/