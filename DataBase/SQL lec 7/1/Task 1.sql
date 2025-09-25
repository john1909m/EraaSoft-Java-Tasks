------------------task 1-----------------

--Write a query to display the names of employees and their department names using a natural join.
SELECT e.FIRST_NAME, d.DEPARTMENT_NAME  FROM EMPLOYEES e NATURAL JOIN DEPARTMENTS d; 

--Write a query to list all orders with their corresponding customer names using a natural join.
SELECT * FROM ORDERS o NATURAL JOIN CUSTOMERS c;

--Write a query to show student names and the courses they are enrolled in using a natural join.
SELECT student_name, course_name FROM students NATURAL JOIN courses;

--Write a query to display project names and the employees working on them using a natural join.
SELECT project_name,first_name FROM projects NATURAL JOIN EMPLOYEES e; 

--Write a query to retrieve invoice details along with product names using a natural join.
SELECT invoice_details, product_name FROM invoices NATURAL JOIN products;

--Write a query to find all books with their respective author names using a natural join.
SELECT book_title, author_name FROM books NATURAL JOIN authors;

--Write a query to list all class schedules along with their instructors’ names using a natural join.
SELECT class_id, schedule_time, instructor_name FROM class_schedules NATURAL JOIN instructors;

--Write a query to show supplier names and the products they supply using a natural join.
SELECT supplier_name, product_name FROM suppliers NATURAL JOIN products;

--Write a query to display customer orders along with shipping details using a natural join.
SELECT order_id, customer_name, shipping_address, shipping_date FROM orders NATURAL JOIN shipping;

--Write a query to list employees along with their job titles using a natural join.
SELECT employee_name, job_title FROM employees NATURAL JOIN jobs;

