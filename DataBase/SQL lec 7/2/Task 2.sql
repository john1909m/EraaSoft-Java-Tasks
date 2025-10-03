--💡 Oracle SQL – RIGHT OUTER JOIN Coding Questions
--List all departments and the employees working in them.
--Use a RIGHT OUTER JOIN to ensure all departments are shown, even if they have no employees.
SELECT e.employee_id,
       e.first_name,
       e.last_name,
       d.department_id,
       d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

--Retrieve all orders and their corresponding customers.
--Use a RIGHT JOIN to include all customers, even if they haven't placed any orders.
SELECT o.order_id,
       o.order_date,
       c.customer_id,
       c.customer_name
FROM orders o
RIGHT OUTER JOIN customers c
ON o.customer_id = c.customer_id;

--Show all courses and enrolled students.
--Use RIGHT JOIN to return all courses, including those without any enrolled students.
SELECT s.student_id,
       s.student_name,
       c.course_id,
       c.course_name
FROM students s
RIGHT OUTER JOIN enrollments e
ON s.student_id = e.student_id
RIGHT OUTER JOIN courses c
ON e.course_id = c.course_id;

--Display all projects and the employees assigned to them.
--Use a RIGHT OUTER JOIN to include all projects even if no employee is assigned.
SELECT e.employee_id,
       e.first_name,
       p.project_id,
       p.project_name
FROM employees e
RIGHT OUTER JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
RIGHT OUTER JOIN projects p
ON pa.project_id = p.project_id;

--Write a query to show all payment methods and their related transactions.
--Include payment methods with no transactions using RIGHT JOIN.
SELECT t.transaction_id,
       t.amount,
       pm.payment_method_id,
       pm.method_name
FROM transactions t
RIGHT OUTER JOIN payment_methods pm
ON t.payment_method_id = pm.payment_method_id;

--Find all authors and their books.
--Use a RIGHT OUTER JOIN to list all authors, even those who haven't written any books.
SELECT b.book_id,
       b.title,
       a.author_id,
       a.author_name
FROM books b
RIGHT OUTER JOIN authors a
ON b.author_id = a.author_id;

--List all categories and the products under them.
--Use a RIGHT JOIN to ensure all categories are shown, even those with no products.
SELECT p.product_id,
       p.product_name,
       c.category_id,
       c.category_name
FROM products p
RIGHT OUTER JOIN categories c
ON p.category_id = c.category_id;

--Retrieve all students and their assigned dorm rooms.
--Use a RIGHT OUTER JOIN to include dorm rooms even if they are unassigned.
SELECT s.student_id,
       s.student_name,
       d.dorm_id,
       d.dorm_room
FROM students s
RIGHT OUTER JOIN dorms d
ON s.dorm_id = d.dorm_id;
