CREATE TABLE doctor(
	id NUMBER,
	name VARCHAR(50),
	salary NUMBER,
	address VARCHAR(255)
);
DROP TABLE doctor;
INSERT INTO doctor VALUES (1, 'john', 15000, 'october');
INSERT INTO doctor VALUES (2, 'maria', 18000, 'cairo');
INSERT INTO doctor VALUES (3, 'ahmed', 14000, 'giza');
INSERT INTO doctor VALUES (4, 'sara', 20000, 'alexandria');
INSERT INTO doctor VALUES (5, 'david', 17500, 'menofia');
INSERT INTO doctor VALUES (6, 'lina', 16000, 'tanta');
INSERT INTO doctor VALUES (7, 'hassan', 15500, 'fayoum');
INSERT INTO doctor VALUES (8, 'emily', 19000, 'aswan');
INSERT INTO doctor VALUES (9, 'khaled', 14500, 'luxor');
INSERT INTO doctor VALUES (10, 'noor', 17000, 'mansoura');
UPDATE doctor SET SALARY=20000 WHERE ID =3;
DELETE DOCTOR WHERE ID=9;
SELECT * FROM doctor;

SELECT name || '-' || salary AS name_Salary FROM doctor;
SELECT id,name,salary*2 double_salary,address FROM doctor;
SELECT * FROM DOCTOR WHERE salary IN (1000,2000,3000);
ALTER TABLE doctor RENAME TO prd_DOCTOR;