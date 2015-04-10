DELETE FROM obinit_obvisit_link WHERE id = 1;
DELETE FROM obvisit WHERE id = 1;

INSERT INTO obvisit (id, visitDate, numWeeksPregnant, weight, bloodPressure, heartRate, fundalHeight) VALUES (1, "2005-04-30", "2", 3.0, 4, 5, 4.4);

INSERT INTO obinit_obvisit_link (id, visitID, initID) VALUES (1, 1, 3);