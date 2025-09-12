---------------------Task 1-------------------
CREATE TABLE player (
	id NUMBER NOT NULL UNIQUE ,
	name VARCHAR(50) UNIQUE,
	age NUMBER
);
CREATE TABLE manager (
	id NUMBER NOT NULL ,
	name VARCHAR(50) UNIQUE,
	salary NUMBER,
	CONSTRAINT uni_name_id UNIQUE (id,name)
);
DROP TABLE manager;

CREATE TABLE manager (
	id NUMBER CONSTRAINT uni_id PRIMARY KEY,
	name VARCHAR(50),
	age NUMBER
);



------------------TASK 2---------------

CREATE TABLE Doctor (
    id NUMBER CONSTRAINT pk_doctor PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER
);

CREATE TABLE Patient (
    id   NUMBER CONSTRAINT pk_patient PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age  NUMBER
);
SELECT * FROM doctor;
CREATE TABLE doctor_patient(
	doctor_id NUMBER,
	patient_id NUMBER,
	CONSTRAINT pk_doctor_patient PRIMARY KEY (doctor_id,patient_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES Patient(id)
);

----------------TASK 3---------------

CREATE TABLE teacher(
	id NUMBER CONSTRAINT pk_teacher PRIMARY KEY,
	name VARCHAR(50),
	salary NUMBER,
	language_id NUMBER,
	CONSTRAINT fk_teacher FOREIGN KEY (language_id) REFERENCES language(id)
);

CREATE TABLE language(
	id NUMBER CONSTRAINT pk_language PRIMARY KEY,
	name VARCHAR(50)
);


-----------------TASK 4----------------

CREATE TABLE Employee (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100) NOT NULL,
    age NUMBER
);

CREATE TABLE Phone (
    phone_id     NUMBER PRIMARY KEY,
    phone_number VARCHAR2(20) NOT NULL,
    employee_id  NUMBER UNIQUE,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

---------------TASK 5----------------------
CREATE TABLE Doctor (
    id NUMBER CONSTRAINT pk_doctor PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER
);

CREATE TABLE Patient (
    id   NUMBER CONSTRAINT pk_patient PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age  NUMBER
);
SELECT * FROM doctor;
CREATE TABLE doctor_patient(
	doctor_id NUMBER,
	patient_id NUMBER,
	CONSTRAINT pk_doctor_patient PRIMARY KEY (doctor_id,patient_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES Patient(id)
);


----------------TASK 6---------------
--------------------LIKE TASK 3---------------


--------------TASK 7-----------------
--------------------LIKE TASK 4---------------