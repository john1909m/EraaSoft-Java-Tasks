SELECT * FROM EMPLOYEES_COPY;
--1. Find all employee where the emp_id is within a certain range  100  and  105.
SELECT * FROM EMPLOYEES_COPY ec WHERE ec.EMPLOYEE_ID IN (100,105);

--2. Find all employee that belong to a specific set of emp_id  151 , 152, 153, 154 , 155.
SELECT * FROM EMPLOYEES_COPY WHERE EMPLOYEE_ID BETWEEN 151 AND 155;

--3. Retrieve all employee where the employee first_name starts with the letter 'P' OR 'p'
SELECT * FROM EMPLOYEES_COPY WHERE upper(FIRST_NAME) LIKE 'P%';

--4. Retrieve all employee where the employee first_name end with the letter 'A' OR 'a'
SELECT * FROM EMPLOYEES_COPY WHERE upper(FIRST_NAME) LIKE '%A';

--5. Retrieve all employee where the employee first_name with the letter 'A' OR 'a'
SELECT * FROM EMPLOYEES_COPY WHERE upper(FIRST_NAME) LIKE '%A%';

--6. Retrieve all employee where the employee first_name  third char with the letter 'e' OR 'E'
SELECT * FROM EMPLOYEES_COPY WHERE upper(FIRST_NAME) LIKE '___E%';

--7. Retrieve all employees who don't have a manager assigned (i.e., manager_id is NULL).
SELECT * FROM EMPLOYEES_COPY WHERE MANAGER_ID IS NULL;

--8. Find all employees who have a manager assigned.
SELECT * FROM EMPLOYEES_COPY WHERE MANAGER_ID IS NOT NULL;

--9. Insert a new employee without assigning a manager (NULL value for manager_id).
INSERT INTO EMPLOYEES_copy VALUES (211, 'john', 'emil', 'johnemil', '123456789', TO_DATE('2005-09-21', 'YYYY-MM-DD'), 'IT', 15000, NULL, NULL, 50);

--10. Find all employees who work either in the 'AD_VP' JOB_ID or the 'IT_PROG' JOB_ID.
SELECT * FROM EMPLOYEES_COPY WHERE JOB_ID ='AD_VP' OR JOB_ID ='IT_PROG';

--11. Retrieve all employees sorted by their last_name in ascending order.
SELECT * FROM EMPLOYEES_COPY ORDER BY LAST_NAME ASC;

--12. Retrieve all employees sorted by their hire_date in descending order.
SELECT * FROM EMPLOYEES_COPY ORDER BY HIRE_DATE DESC;

--13. Sort employees first by department in ascending order and then by salary in descending order within each department_id.
SELECT * FROM EMPLOYEES_COPY ORDER BY DEPARTMENT_ID ASC,salary DESC ;

--14. Retrieve all employees with their last_name in lowercase
SELECT LOWER(last_name) FROM EMPLOYEES_COPY;

--15. Retrieve all employees with their first_name in uppercase.
SELECT upper(first_name) FROM EMPLOYEES_COPY;

--16. Retrieve all employees with their first_name and last_name in title case (first letter capitalized).
SELECT INITCAP(first_name),INITCAP(last_name) FROM EMPLOYEES_COPY;

--17. Find employees whose last_name is 'smith', regardless of the case.
SELECT * FROM EMPLOYEES_COPY WHERE lower(LAST_NAME) LIKE 'smith';


