--💡 Oracle SQL – LEFT OUTER JOIN Coding Questions
--Retrieve all employees and their department names.
--Write an Oracle SQL query using LEFT OUTER JOIN to show all employees, including those who are not assigned to any department.
SELECT e.employee_id,
       e.first_name,
       e.last_name,
       d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

--List all products and their associated categories.
--Some products may not belong to any category. Write a query using LEFT JOIN to include all products regardless of category association.
SELECT p.product_id,
       p.product_name,
       c.category_name
FROM products p
LEFT OUTER JOIN categories c
ON p.category_id = c.category_id;


--Find all students and the courses they are enrolled in.
--Use a LEFT OUTER JOIN to include students who are not enrolled in any course.
SELECT s.student_id,
       s.student_name,
       c.course_name
FROM students s
LEFT OUTER JOIN enrollments e
ON s.student_id = e.student_id
LEFT OUTER JOIN courses c
ON e.course_id = c.course_id;


--Display all orders with customer names, including orders without a matched customer.
--Assume the orders table has a foreign key customer_id. Use LEFT JOIN to include all orders.
SELECT o.order_id,
       o.order_date,
       c.customer_name
FROM orders o
LEFT OUTER JOIN customers c
ON o.customer_id = c.customer_id;

--Show all departments and their managers.
--Write a query to return all departments using a LEFT OUTER JOIN to show their assigned managers, including departments with no manager.
SELECT d.department_id,
       d.department_name,
       m.manager_name
FROM departments d
LEFT OUTER JOIN managers m
ON d.manager_id = m.manager_id;

--List all books and their authors from the books and authors tables.
--Include books that don’t have an assigned author using a LEFT JOIN.
SELECT b.book_id,
       b.title,
       a.author_name
FROM books b
LEFT OUTER JOIN authors a
ON b.author_id = a.author_id;

--Write a query that retrieves all invoices along with their corresponding payment status.
--Use LEFT JOIN to include invoices with no payment.
SELECT i.invoice_id,
       i.invoice_date,
       p.payment_status
FROM invoices i
LEFT OUTER JOIN payments p
ON i.invoice_id = p.invoice_id;

--Get all employees and their projects from employees and projects_assigned tables.
--Include employees who are not assigned to any project.
SELECT e.employee_id,
       e.first_name,
       e.last_name,
       p.project_name
FROM employees e
LEFT OUTER JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
LEFT OUTER JOIN projects p
ON pa.project_id = p.project_id;
