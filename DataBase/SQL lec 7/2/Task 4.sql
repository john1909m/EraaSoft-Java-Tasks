-- Find the names of employees who earn more than the average salary.
-- Use a subquery to calculate the average salary.
SELECT first_name, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- List the customers who placed the highest number of orders.
-- Use a subquery to count orders per customer and compare with the max count.
SELECT customer_id, customer_name
FROM customers
WHERE customer_id IN (
    SELECT customer_id
    FROM orders
    GROUP BY customer_id
    HAVING COUNT(order_id) = (
        SELECT MAX(order_count)
        FROM (
            SELECT customer_id, COUNT(order_id) AS order_count
            FROM orders
            GROUP BY customer_id
        )
    )
);

-- Retrieve all products whose price is higher than any product in the ‘Accessories’ category.
-- Use a subquery inside a WHERE clause with ANY.
SELECT product_id, product_name, price
FROM products
WHERE price > ANY (
    SELECT price
    FROM products
    WHERE category = 'Accessories'
);

-- Display employees who work in the same department as 'John Smith'.
-- Use a subquery to get John Smith’s department ID.
SELECT first_name, last_name, department_id
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE first_name = 'John' AND last_name = 'Smith'
);

-- Get all orders that were placed by customers from 'New York'.
-- Use a subquery to filter customers based on city.
SELECT order_id, order_date, customer_id
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

-- Find the departments that have no employees.
-- Use a NOT EXISTS subquery to check for departments without employees.
SELECT department_id, department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM employees e
    WHERE e.department_id = d.department_id
);

-- List the students who are not enrolled in any course.
-- Use a subquery with NOT IN or NOT EXISTS.
SELECT student_id, student_name
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

-- Retrieve the second highest salary from the employees table.
-- Use a subquery with MAX and WHERE.
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);

-- Display products that have a price greater than the average price of all products.
-- Use a scalar subquery to get the average price.
SELECT product_id, product_name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products);

-- Find customers who have ordered all products in category 'A'.
-- Use a correlated subquery with NOT EXISTS.
SELECT c.customer_id, c.customer_name
FROM customers c
WHERE NOT EXISTS (
    SELECT p.product_id
    FROM products p
    WHERE p.category = 'A'
      AND NOT EXISTS (
          SELECT 1
          FROM orders o
          JOIN order_items oi ON o.order_id = oi.order_id
          WHERE o.customer_id = c.customer_id
          AND oi.product_id = p.product_id
      )
);
