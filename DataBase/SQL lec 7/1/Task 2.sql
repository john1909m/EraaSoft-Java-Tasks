--------------------Task 2-------------------

--Write a query to display employee names and department names by joining the employees and departments tables using the USING clause on department_id.
SELECT e.FIRST_NAME ,d.DEPARTMENT_NAME  FROM EMPLOYEES e JOIN DEPARTMENTS d USING (DEPARTMENT_ID);

--Write a query to list all orders and their corresponding customer names using the USING clause on customer_id.
SELECT o.order_id, c.customer_name FROM orders o JOIN customers c USING (customer_id);

--Write a query to retrieve product names and supplier names from the products and suppliers tables using the USING clause on supplier_id.
SELECT p.product_name, s.supplier_name FROM products p JOIN suppliers s USING (supplier_id);

--Write a query to show student names and course titles by joining students and enrollments using the USING clause on student_id.
SELECT s.student_name, c.course_title FROM students s JOIN enrollments e USING (student_id)

--Write a query to display invoice numbers and product names by joining invoices and products using the USING clause on product_id.
SELECT i.invoice_number, p.product_name FROM invoices i JOIN products p USING (product_id);

--Write a query to list project names and employee names using the USING clause on project_id.
SELECT p.project_name, e.employee_name FROM projects p JOIN employees e USING (project_id);


--Write a query to retrieve author names and book titles using the USING clause on author_id.
SELECT a.author_name, b.book_title FROM authors a JOIN books b USING (author_id);


--Write a query to show sales order details with employee names using the USING clause on employee_id.
SELECT s.order_id, e.employee_name FROM sales_orders s JOIN employees e USING (employee_id);


--Write a query to display course schedules and instructor names using the USING clause on instructor_id.
SELECT cs.schedule_time, i.instructor_name FROM course_schedules cs JOIN instructors i USING (instructor_id);


--Write a query to list transactions along with account holder names using the USING clause on account_id.
SELECT t.transaction_id, a.account_holder_name FROM transactions t JOIN accounts a USING (account_id);



