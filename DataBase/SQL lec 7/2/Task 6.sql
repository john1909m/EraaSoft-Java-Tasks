-- Find all employees who earn more than at least one employee in department 10.
-- Use a subquery with ANY or SOME.
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary > ANY (
    SELECT salary
    FROM employees
    WHERE department_id = 10
);

-- List the employees who earn less than all employees in department 20.
-- Use a subquery with ALL.
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary < ALL (
    SELECT salary
    FROM employees
    WHERE department_id = 20
);

-- Display products that have a price equal to any product in the 'Electronics' category.
-- Use a subquery inside an IN clause.
SELECT product_id, product_name, price
FROM products
WHERE price IN (
    SELECT price
    FROM products
    WHERE category = 'Electronics'
);

-- Retrieve names of customers who have placed an order for a product with price greater than $1000.
-- Use a subquery with IN or EXISTS.
SELECT DISTINCT c.customer_id, c.customer_name
FROM customers c
WHERE c.customer_id IN (
    SELECT o.customer_id
    FROM orders o
    JOIN order_items oi ON o.order_id = oi.order_id
    WHERE oi.price > 1000
);

-- List the employees who work in the same job titles as at least one other employee.
-- Use a subquery with IN on job titles.
SELECT employee_id, first_name, last_name, job_id
FROM employees
WHERE job_id IN (
    SELECT job_id
    FROM employees
    GROUP BY job_id
    HAVING COUNT(*) > 1
);

-- Find the departments that have more than one employee.
-- Use a subquery with GROUP BY and HAVING, or join with a subquery returning multiple department IDs.
SELECT department_id, department_name
FROM departments
WHERE department_id IN (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 1
);

-- Show all orders placed by customers who are from cities where other customers have placed orders too.
-- Use a correlated subquery or a multiple-row subquery with IN.
SELECT o.order_id, o.order_date, o.customer_id
FROM orders o
WHERE o.customer_id IN (
    SELECT c1.customer_id
    FROM customers c1
    WHERE c1.city IN (
        SELECT city
        FROM customers
        GROUP BY city
        HAVING COUNT(customer_id) > 1
    )
);

-- List all books that were written by authors who have published more than one book.
-- Use a subquery with GROUP BY and HAVING.
SELECT book_id, title, author_id
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(*) > 1
);

-- Display the names of students who are enrolled in any of the courses taught by professor 'Dr. Smith'.
-- Use a subquery to get course IDs.
SELECT DISTINCT s.student_id, s.student_name
FROM students s
WHERE s.student_id IN (
    SELECT e.student_id
    FROM enrollments e
    WHERE e.course_id IN (
        SELECT course_id
        FROM courses
        WHERE professor = 'Dr. Smith'
    )
);

-- Retrieve all employees whose salary matches any of the salaries in department 30.
-- Use a subquery with IN.
SELECT employee_id, first_name, last_name, salary
FROM employees
WHERE salary IN (
    SELECT salary
    FROM employees
    WHERE department_id = 30
);
