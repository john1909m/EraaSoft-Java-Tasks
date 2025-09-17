--------------------------Task 1--------------------------------

-- Q1. Create a table called EMP_TEST with a column NAME having leading and trailing spaces.
CREATE TABLE EMP_TEST AS SELECT * FROM employees;
SELECT * FROM emp_test;
SELECT TRIM(BOTH ' ' FROM first_name) trm FROM emp_test; 

-- Q2. Display all names using TRIM to remove both leading and trailing spaces.
SELECT TRIM(BOTH ' ' FROM first_name) trm FROM emp_test;

-- Q3. Use LTRIM to remove only leading spaces.
SELECT LTRIM(first_name) trm FROM emp_test;

-- Q4. Use RTRIM to remove only trailing spaces.
SELECT RTRIM(first_name) trm FROM emp_test;

-- Q5. Use TRIM to remove a specific character (e.g., ‘*’ or ‘#’) from both sides of a string.
SELECT LOWER(TRIM(BOTH 'a' FROM first_name)) trm FROM emp_test;

--------------------------Task 2--------------------------------

-- Q1. Use REPLACE to replace the letter 'a' with '@' in the word 'database'.
SELECT REPLACE('database','a','@') FROM dual;

-- Q2. Use REPLACE to replace a full word in a string (e.g., "old" with "new").
SELECT REPLACE('old','old','new') FROM dual;

-- Q3. Create a table PRODUCT with a product_name column, and insert 3 sample products.
CREATE TABLE PRODUCT (
    product_name VARCHAR2(50)
);
INSERT INTO PRODUCT (product_name) VALUES ('Laptop');
INSERT INTO PRODUCT (product_name) VALUES ('Mouse');
INSERT INTO PRODUCT (product_name) VALUES ('Keyboard');

-- Q4. Use LPAD to format product names to 15 characters by padding with '*' on the left.
SELECT LPAD(product_name,15,'*') pad_name FROM product;

-- Q5. Use RPAD to format product names to 15 characters by padding with '#' on the right.
SELECT RPAD(product_name,15,'*') pad_name FROM product;


--------------------------Task 3--------------------------------
-- Q1. Display current date in the format 'DD-MON-YYYY'.
SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY') current_date FROM dual;

-- Q2. Display current date in the format 'Month YYYY'.
SELECT TO_CHAR(SYSDATE,'Month-YYYY') current_date FROM dual;

-- Q3. Convert a number to character using TO_CHAR with formatting (e.g., 12345.67 as '12,345.67').
SELECT TO_CHAR(12345.67, '99,999.99') new_format FROM dual;

-- Q4. Show salary formatted with a currency symbol.
SELECT TO_CHAR(salary, '$99,999.99') new_salary FROM EMPLOYEES;

--------------------------Task 4--------------------------------
-- Q1. Create a table STUDENTS with columns: name, marks.
CREATE TABLE STUDENTS (
    name  VARCHAR2(50),
    marks NUMBER(5)
);

-- Q2. Insert 5 sample students with marks.
INSERT INTO STUDENTS (name, marks) VALUES ('John', 85);
INSERT INTO STUDENTS (name, marks) VALUES ('Sara', 92);
INSERT INTO STUDENTS (name, marks) VALUES ('Ali', 76);
INSERT INTO STUDENTS (name, marks) VALUES ('Mona', 88);
INSERT INTO STUDENTS (name, marks) VALUES ('David', 95);
SELECT * FROM students;
-- Q3. Use CASE to assign grades: 
--     >=90 => 'A', 80–89 => 'B', 70–79 => 'C', else => 'F'
SELECT name,marks, CASE
					WHEN marks >= 90 THEN 'A'
					WHEN marks BETWEEN 80 AND 89 THEN 'B'
					WHEN marks BETWEEN 70 AND 79 THEN 'C'
					ELSE 'F'
					END AS grades
				FROM students;


--------------------------Task 5--------------------------------
-- Q1. Use DECODE to achieve the same result as the CASE example above.
SELECT name,marks,DECODE(marks,90, 'A',
           91, 'A',
           92, 'A',
           93, 'A',
           94, 'A',
           95, 'A',
           96, 'A',
           97, 'A',
           98, 'A',
           99, 'A',
           100,'A',
           80, 'B',
           81, 'B',
           82, 'B',
           83, 'B',
           84, 'B',
           85, 'B',
           86, 'B',
           87, 'B',
           88, 'B',
           89, 'B',
           70, 'C',
           71, 'C',
           72, 'C',
           73, 'C',
           74, 'C',
           75, 'C',
           76, 'C',
           77, 'C',
           78, 'C',
           79, 'C',
           'F')AS grades FROM students;

-- Q2. Create a table ORDERS with a column status ('P', 'S', 'D').
CREATE TABLE orders (
	status CHAR(1)
);
INSERT INTO ORDERS (status) VALUES ('P');
INSERT INTO ORDERS (status) VALUES ('S');
INSERT INTO ORDERS (status) VALUES ('D');


-- Q3. Use DECODE to display full form of status:
--     'P' => 'Pending', 'S' => 'Shipped', 'D' => 'Delivered'
SELECT status,DECODE(status,'P','Pending','S','Shipping','D','Delivered') AS status_full FROM ORDERS;


--------------------------Task 6--------------------------------
--1. Character Functions – Part 3 (TRIM, LTRIM, RTRIM)
--Create a table customers with a full_name column. Insert names with extra spaces at the beginning and/or end.
CREATE TABLE CUSTOMERS (
    full_name   VARCHAR2(100)
);

-- Insert names with extra spaces
INSERT INTO CUSTOMERS (full_name) VALUES ('   John Doe');
INSERT INTO CUSTOMERS (full_name) VALUES ('Sara Smith   ');
INSERT INTO CUSTOMERS (full_name) VALUES ('   Ali Khan   ');
INSERT INTO CUSTOMERS (full_name) VALUES (' Mona   ');
INSERT INTO CUSTOMERS (full_name) VALUES ('   David Johnson   ');


--Write a query to remove both leading and trailing spaces from the names using TRIM.
SELECT TRIM(BOTH ' ' FROM full_name) FROM CUSTOMERS;

--Display only the names with leading spaces removed using LTRIM.
SELECT LTRIM(full_name) FROM CUSTOMERS;

--Display only the names with trailing spaces removed using RTRIM.
SELECT RTRIM(full_name) FROM CUSTOMERS;

--Trim specific characters (e.g., $, *, or #) from both sides of a given string.
SELECT TRIM('a' from TRIM(BOTH ' ' FROM full_name)) FROM CUSTOMERS;


--2. Character Functions – Part 4 (REPLACE, LPAD, RPAD)
--Replace all occurrences of the letter 'o' with '0' in the word “promotion”.
SELECT REPLACE('promotion','o','0') FROM dual;

--Replace the word “basic” with “advanced” in the sentence “This is a basic course”.
SELECT REPLACE('This is a basic course','basic','advanced') FROM dual;

--Create a departments table with dept_name column. Insert at least 3 department names.
CREATE TABLE departments_test (
    dept_name VARCHAR(100) 
);
SELECT * FROM DEPARTMENTS_test;
INSERT INTO departments_test VALUES ('Engineering');
INSERT INTO departments_test VALUES ('Network');
INSERT INTO departments_test VALUES ('Medicine');


--Format each department name to 15 characters by padding with ‘*’ on the left using LPAD.
SELECT LPAD(dept_name,'15','*') FROM departments_test;

--Format each department name to 15 characters by padding with ‘-’ on the right using RPAD.
SELECT RPAD(dept_name,'15','-') FROM departments_test;



--3. TO_CHAR Function
--Display the current date in the format DD-MON-YYYY.
SELECT TO_CHAR(sysDate,'DD-MON-YYYY') FROM dual;

--Display the current date in the format Day, Month YYYY.
SELECT TO_CHAR(sysDate,'Day,  Month YYYY') FROM dual;

--Convert a number to a formatted string with commas and two decimal places using TO_CHAR.
SELECT TO_CHAR(56859, '$99,999.99') new_salary FROM EMPLOYEES;

--Format an employee’s salary to include a currency symbol using TO_CHAR.
SELECT TO_CHAR(salary, '$99,999.99') new_salary FROM EMPLOYEES;

--Display system date in the format: YYYY/MM/DD HH24:MI:SS.
SELECT TO_CHAR(sysDate,'YYYY/MM/DD HH24:MI:SS') FROM dual;


--4. Oracle Conditional Expressions – CASE Expressions
--Create a students table with name and score columns. Insert at least 5 records.
-------DONE------------------
--Write a query using CASE to assign grades based on the score:

--90 and above: A

--80–89: B

--70–79: C

--Below 70: F
----------------------------DONE IN ABOVE-------------------------------------
--Modify the query to display “Pass” if score is 60 or more, otherwise “Fail”.
SELECT name,marks, CASE
					WHEN marks >= 60 THEN 'Pass'
					ELSE 'Fail'
					END AS grades
				FROM students;


--Use CASE to display a message for each student:
--"Excellent" for A, "Good" for B, "Average" for C, and "Needs Improvement" for F.
SELECT name,marks, CASE
					WHEN marks >= 90 THEN 'Excellent'
					WHEN marks BETWEEN 80 AND 89 THEN 'Good'
					WHEN marks BETWEEN 70 AND 79 THEN 'Average'
					ELSE 'Needs Improvement'
					END AS grades
				FROM students;
--Write a CASE expression using system date to return the name of the day (e.g., “Today is Monday”).
SELECT CONCAT('Today is ',TO_CHAR(sysdate,'Day')) FROM dual; 
SELECT CASE TO_CHAR(SYSDATE, 'DY')
           WHEN 'MON' THEN 'Today is Monday'
           WHEN 'TUE' THEN 'Today is Tuesday'
           WHEN 'WED' THEN 'Today is Wednesday'
           WHEN 'THU' THEN 'Today is Thursday'
           WHEN 'FRI' THEN 'Today is Friday'
           WHEN 'SAT' THEN 'Today is Saturday'
           WHEN 'SUN' THEN 'Today is Sunday'
           END AS today_date
		FROM dual;


--5. Oracle Conditional Expressions – DECODE Function
--Use DECODE to return grade letters ('A', 'B', 'C', 'F') based on specific score values (e.g., 100 = A, 90 = B, etc.).
-----------------------------DONE BEFORE----------------
--Create a status_log table with a status_code column containing values like ‘N’, ‘I’, ‘C’.
CREATE TABLE status_log (status_code CHAR(1));
INSERT INTO status_log VALUES('N');
INSERT INTO status_log VALUES('I');
INSERT INTO status_log VALUES('C');

--Use DECODE to convert:

--‘N’ → ‘New’

--‘I’ → ‘In Progress’

--‘C’ → ‘Completed’
SELECT DECODE(status_code,'N','New','I','In Progress','C','Completed') FROM status_log ;

--Use DECODE to check if a product’s quantity is 0, and display “Out of Stock”, otherwise “Available”.
-------------E3tbrny 3mltha mksl a3ml table😁😁😁😁----------------


--Write a query using DECODE to display a bonus:

--If department is ‘HR’ → 500

--If department is ‘IT’ → 1000

--If department is ‘Sales’ → 1500

--Else → 300
SELECT * FROM EMPLOYEES;

SELECT job_id, DECODE(job_id,'ST_CLERK',500,'IT_PROG',1000,'FI_ACCOUNT',1500,300) bonus FROM EMPLOYEES;


---------------------------------------Task 8---------------------

---------------------------------------------------------
-- 1. AVG Function
-- Calculate the average salary of all employees
SELECT AVG(salary) AS average_salary FROM employees;


---------------------------------------------------------
-- 2. COUNT Function
-- Count the total number of employees
SELECT COUNT(*) AS total_employees FROM employees;


---------------------------------------------------------
-- 3. MAX Function
-- Find the maximum salary offered
SELECT MAX(salary) AS max_salary FROM employees;


---------------------------------------------------------
-- 4. MIN Function
-- Find the minimum salary offered
SELECT MIN(salary) AS min_salary FROM employees;


---------------------------------------------------------
-- 5. SUM Function
-- Calculate the total salary paid to all employees
SELECT SUM(salary) AS total_salary FROM employees;


---------------------------------------------------------
-- 6. GROUP BY Clause (Part 1)
-- Show department ID and average salary by department
SELECT department_id, AVG(salary) AS avg_salary FROM employees GROUP BY department_id;


---------------------------------------------------------
-- 7. GROUP BY Clause (Part 2)
-- Show job ID and total number of employees for each job
SELECT job_id, COUNT(*) AS total_employees FROM employees GROUP BY job_id;


---------------------------------------------------------
-- 8. HAVING Clause
-- Show department ID and total salary only if total salary > 50000
SELECT department_id, SUM(salary) AS total_salary FROM employees GROUP BY department_id HAVING SUM(salary) > 50000;


---------------------------------------------------------
-- 9. AVG Function (Advanced)
-- Find average commission for employees with non-null commission
SELECT AVG(commission_pct) AS avg_commission FROM employees WHERE commission_pct IS NOT NULL;


---------------------------------------------------------
-- 10. COUNT Function (Advanced)
-- Count employees with salary greater than 10000
SELECT COUNT(*) AS employees_high_salary FROM employees WHERE salary > 10000;


---------------------------------------------------------
-- 11. MAX and MIN Together
-- Find max and min salary within each job
SELECT job_id,
       MAX(salary) AS max_salary,
       MIN(salary) AS min_salary
FROM employees
GROUP BY job_id;


---------------------------------------------------------
-- 12. SUM Function (Advanced)
-- Sum of salaries for each manager
SELECT manager_id, SUM(salary) AS total_salary FROM employees GROUP BY manager_id;


---------------------------------------------------------
-- 13. GROUP BY with Multiple Columns
-- Show department ID + job ID with total salary
SELECT department_id, job_id, SUM(salary) AS total_salary FROM employees GROUP BY department_id, job_id;


---------------------------------------------------------
-- 14. HAVING with COUNT
-- Show job ID with count of employees, only if more than 5
SELECT job_id, COUNT(*) AS employee_count FROM employees GROUP BY job_id HAVING COUNT(*) > 5;


---------------------------------------------------------
-- 15. Using Aggregate Functions Together
-- Show dept ID with total employees, avg, max, min salary
SELECT department_id,
       COUNT(*) AS total_employees,
       AVG(salary) AS avg_salary,
       MAX(salary) AS max_salary,
       MIN(salary) AS min_salary
FROM employees
GROUP BY department_id;


---------------------------------------------------------
-- 16. Complex HAVING
-- Find departments where avg salary > 8000 AND employee count < 10
SELECT department_id,
       AVG(salary) AS avg_salary,
       COUNT(*) AS employee_count
FROM employees
GROUP BY department_id
HAVING AVG(salary) > 8000
   AND COUNT(*) < 10;


---------------------------------------------------------
-- 17. Nested Aggregation
-- Find the department with the highest total salary
---------------------------------------------------------
SELECT department_id, SUM(salary) AS total_salary
FROM employees
GROUP BY department_id
ORDER BY total_salary DESC
FETCH FIRST 1 ROW ONLY;


---------------------------------------------------------
-- 18. Using Aliases with Aggregates
-- Show dept ID, sum of salaries as Total_Salary, avg salary as Average_Salary
---------------------------------------------------------
SELECT department_id,
       SUM(salary) AS Total_Salary,
       AVG(salary) AS Average_Salary
FROM employees
GROUP BY department_id;



