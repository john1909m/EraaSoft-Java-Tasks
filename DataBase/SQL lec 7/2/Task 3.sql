-- 💡 Oracle SQL – FULL OUTER JOIN Coding Questions
-- Write a query to list all customers and all orders.
-- Use a FULL OUTER JOIN to include customers with no orders and orders with no matching customer.
SELECT c.customer_id,
       c.customer_name,
       o.order_id,
       o.order_date
FROM customers c
FULL OUTER JOIN orders o
ON c.customer_id = o.customer_id;

-- Display all employees and all projects.
-- Some employees may not be assigned to any project, and some projects may not have any employee.
SELECT e.employee_id,
       e.first_name,
       p.project_id,
       p.project_name
FROM employees e
FULL OUTER JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
FULL OUTER JOIN projects p
ON pa.project_id = p.project_id;

-- Show all products and all suppliers.
-- Include products without suppliers and suppliers without products.
SELECT p.product_id,
       p.product_name,
       s.supplier_id,
       s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s
ON p.supplier_id = s.supplier_id;

-- List all students and all courses.
-- Include students not enrolled in any course and courses with no students.
SELECT s.student_id,
       s.student_name,
       c.course_id,
       c.course_name
FROM students s
FULL OUTER JOIN enrollments e
ON s.student_id = e.student_id
FULL OUTER JOIN courses c
ON e.course_id = c.course_id;

-- Retrieve all authors and all books.
-- Include authors with no books and books without an assigned author.
SELECT a.author_id,
       a.author_name,
       b.book_id,
       b.title
FROM authors a
FULL OUTER JOIN books b
ON a.author_id = b.author_id;

-- Write a query to find all employees and all departments.
-- Include employees not assigned to any department and departments with no employees.
SELECT e.employee_id,
       e.first_name,
       d.department_id,
       d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;

-- Show all transactions and all payment methods.
-- Include unmatched records from both sides.
SELECT t.transaction_id,
       t.amount,
       pm.payment_method_id,
       pm.method_name
FROM transactions t
FULL OUTER JOIN payment_methods pm
ON t.payment_method_id = pm.payment_method_id;

-- Combine two customer lists from two different regions.
-- Use FULL OUTER JOIN to include all customers from both regions, even if they don’t exist in both lists.
SELECT r1.customer_id AS region1_customer_id,
       r1.customer_name AS region1_customer,
       r2.customer_id AS region2_customer_id,
       r2.customer_name AS region2_customer
FROM region1_customers r1
FULL OUTER JOIN region2_customers r2
ON r1.customer_id = r2.customer_id;
