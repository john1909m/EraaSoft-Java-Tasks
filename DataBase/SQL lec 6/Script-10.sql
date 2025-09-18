--✅ 1. CHECK Constraint (Code Samples)
--Create a table Employees with a CHECK constraint that ensures age is greater than or equal to 18.
CREATE TABLE employees_new (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100) NOT NULL,
    age NUMBER CHECK (age >= 18)
);

--Write a SQL query to enforce that salary in a Staff table must be between 3000 and 10000.
CREATE TABLE Staff (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER CHECK (SALARY >= 3000 AND salary <=10000)
);
--Add a CHECK constraint to an existing table Products that ensures price is greater than 0.
	CREATE TABLE Products (
	    product_id   NUMBER ,
	    product_name VARCHAR2(100) NOT NULL,
	    price        NUMBER(10,2) NOT NULL
);
ALTER TABLE products ADD CONSTRAINT price_more_0 CHECK (price > 0);

--Create a table Students where the grade column only allows values from A to F using a CHECK constraint.
ALTER TABLE students ADD grade char(1);
ALTER TABLE students ADD CONSTRAINT grade_check CHECK (grade IN ('A','B','C','D','E','F'));




--🛠️ 2. Adding Constraints via ALTER TABLE (Code Samples)
--Add a NOT NULL constraint to the email column in the Customers table.
ALTER TABLE customers ADD CONSTRAINT email_check CHECK (full_name IS NOT NULL);
--Add a UNIQUE constraint to the username column in the Users table.
ALTER TABLE users ADD CONSTRAINT uni_name CHECK(username IS UNIQUE);
--Add a FOREIGN KEY constraint on Orders.customer_id referencing Customers(id).
ALTER TABLE Orders ADD CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES Customers(id);

--Use ALTER TABLE to add a CHECK constraint to the Accounts table to ensure balance >= 0.
ALTER TABLE Accounts ADD CONSTRAINT chk_balance_nonnegative CHECK (balance >= 0);

--Add a PRIMARY KEY constraint to the Departments table on the dept_id column.
ALTER TABLE Departments ADD CONSTRAINT pk_departments PRIMARY KEY (dept_id);



--❌ 3. Dropping (Removing) Constraints (Code Samples)
--Drop a CHECK constraint named chk_salary from the Employees table.
ALTER TABLE Employees DROP CONSTRAINT chk_salary;

--Remove the UNIQUE constraint on email from the Users table.
ALTER TABLE Users DROP CONSTRAINT email_uni_not_null;

--Drop the PRIMARY KEY from the Products table.
ALTER TABLE Products DROP PRIMARY KEY;

--Drop a FOREIGN KEY constraint named fk_order_customer from the Orders table.
ALTER TABLE Orders DROP CONSTRAINT fk_order_customer;

--Write SQL to remove a NOT NULL constraint from the phone column in the Contacts table.
ALTER TABLE Contacts MODIFY phone NULL;


--✏️ 4. Renaming Constraints (Code Samples)
--Rename a CHECK constraint named chk_age to check_min_age on the Students table.
ALTER TABLE Students RENAME CONSTRAINT chk_age TO check_min_age;

--Rename a FOREIGN KEY constraint fk_emp_dept to fk_employee_department on the Employees table.
ALTER TABLE Employees RENAME CONSTRAINT fk_emp_dept TO fk_employee_department;

--Rename the PRIMARY KEY constraint on the Users table to pk_users_id.
ALTER TABLE Users RENAME CONSTRAINT old_pk_name TO pk_users_id;

--Write SQL to rename the UNIQUE constraint on the username column to uk_user_name.
ALTER TABLE Users RENAME CONSTRAINT old_unique_name TO uk_user_name;

--Provide the syntax to rename a constraint in SQL Server vs PostgreSQL.
--SQL SERVER:
EXEC sp_rename 'Employees.fk_emp_dept', 'fk_employee_department', 'OBJECT';

--POSTGRESQL:
ALTER TABLE employees RENAME CONSTRAINT fk_emp_dept TO fk_employee_department;


--🚫 5. Disabling Constraints (Code Samples)
--Disable a FOREIGN KEY constraint named fk_customer_order on the Orders table.
ALTER TABLE Orders DISABLE CONSTRAINT fk_customer_order;

--Temporarily disable all constraints on the Products table.
ALTER TABLE Products DISABLE ALL CONSTRAINTS;

--Write SQL to disable the CHECK constraint on the Accounts.balance column.
ALTER TABLE Accounts DISABLE CONSTRAINT chk_balance;

--Disable the PRIMARY KEY constraint on Departments(dept_id).
ALTER TABLE Departments DISABLE CONSTRAINT pk_departments;

--How would you disable all constraints on a table before bulk inserting data?
ALTER TABLE table_name DISABLE ALL CONSTRAINTS;




--✅ 6. Enabling Constraints (Code Samples)
--Enable the FOREIGN KEY constraint fk_customer_order on the Orders table.
ALTER TABLE Orders ENABLE CONSTRAINT fk_customer_order;

--Re-enable all constraints on the Products table after a data load.
ALTER TABLE Products ENABLE ALL CONSTRAINTS;

--Write SQL to enable a CHECK constraint on salary in the Staff table.
ALTER TABLE Staff ENABLE CONSTRAINT chk_salary;

--Enable the PRIMARY KEY constraint on Departments(dept_id) after it was disabled.
ALTER TABLE Departments ENABLE CONSTRAINT pk_departments;

--How do you enable a constraint only if it's currently disabled?
----❌❌❌❌❌❌❌❌❌❌❌❌❌
