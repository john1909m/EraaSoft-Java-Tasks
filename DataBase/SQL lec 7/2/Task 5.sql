-- Find the employee(s) with the highest salary.
-- Use a single-row subquery to get the maximum salary.
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);

-- List the names of employees who work in the same department as employee 'Alice'.
-- Use a subquery to get the department ID of 'Alice'.
SELECT employee_id, first_name, last_name
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE first_name = 'Alice'
);

-- Display the details of the product with the lowest price.
-- Use a single-row subquery to get the minimum price.
SELECT product_id, product_name, price
FROM products
WHERE price = (SELECT MIN(price) FROM products);

-- Retrieve the department name of the employee with the highest salary.
-- Use nested subqueries: one to find the employee, and one to find the department.
SELECT department_name
FROM departments
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE salary = (SELECT MAX(salary) FROM employees)
);

-- Find the manager of the employee who was hired most recently.
-- Use a subquery to get the employee with the latest hire date.
SELECT manager_id
FROM employees
WHERE employee_id = (
    SELECT employee_id
    FROM employees
    WHERE hire_date = (SELECT MAX(hire_date) FROM employees)
);

-- Show the employee whose salary is equal to the average salary of the company.
-- Use a single-row subquery with AVG().
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary = (SELECT AVG(salary) FROM employees);

-- List the order(s) with the earliest order date.
-- Use a subquery to get the minimum order date.
SELECT order_id, order_date, customer_id
FROM orders
WHERE order_date = (SELECT MIN(order_date) FROM orders);

-- Get the name and salary of the employee who earns more than the employee with ID = 101.
-- Use a single-row subquery to get the salary of employee 101.
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE employee_id = 101);

-- Find the student who has the same GPA as student 'John Doe'.
-- Use a subquery to get 'John Doe’s GPA'.
SELECT student_id, student_name, gpa
FROM students
WHERE gpa = (
    SELECT gpa
    FROM students
    WHERE student_name = 'John Doe'
);

-- Display all books that have the same price as the most expensive book in the ‘Science’ category.
-- Use a subquery to find the max price from the 'Science' category.
SELECT book_id, title, price
FROM books
WHERE price = (
    SELECT MAX(price)
    FROM books
    WHERE category = 'Science'
);
