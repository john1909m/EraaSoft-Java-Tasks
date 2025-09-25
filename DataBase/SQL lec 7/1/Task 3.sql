--------------Task 3----------------

--Write a query to retrieve employee names and their manager names from the employees table, handling ambiguous column names for employee_id and manager_id.
SELECT e.FIRST_NAME  AS employee, m.FIRST_NAME  AS manager FROM employees e JOIN employees m ON e.manager_id = m.employee_id;

--Write a query to list customer names and salesperson names from the customers and employees tables, where both tables have a column named name.
SELECT c.name AS customer_name, e.name AS salesperson_name FROM customers c JOIN employees e ON c.salesperson_id = e.employee_id;


--Write a query to display order IDs and product IDs from orders and order_details, both of which have an order_id column.
SELECT o.order_id, od.product_id FROM orders o JOIN order_details od ON o.order_id = od.order_id;


--Write a query to retrieve student names and instructor names from students and instructors tables using an alias to handle the name column.
SELECT s.name AS student_name, i.name AS instructor_name FROM students s JOIN instructors i ON s.instructor_id = i.instructor_id;

--Write a query to show employee salaries and department budgets, both of which have a budget or salary column that could conflict.
SELECT e.salary, d.budget FROM employees e JOIN departments d ON e.department_id = d.department_id;

--Write a query to display project names and task names where both projects and tasks tables contain a name column.
SELECT p.name AS project_name, t.name AS task_name FROM projects p JOIN tasks t ON p.project_id = t.project_id;


--Write a query to join courses and exams tables and retrieve their date fields, resolving ambiguity between the columns.
SELECT c.course_date AS course_date, e.exam_date AS exam_date FROM courses c JOIN exams e ON c.course_id = e.course_id;


--Write a query to show the product name and category name from the products and categories tables, where both have a name column.
SELECT p.name AS product_name, c.name AS category_name FROM products p JOIN categories c ON p.category_id = c.category_id;


--Write a query to display the book title and publisher name from books and publishers, avoiding column name conflicts.
SELECT b.title AS book_title, p.name AS publisher_name FROM books b JOIN publishers p ON b.publisher_id = p.publisher_id;

--Write a query to list employee names and their department's location, resolving ambiguity in the location column from both tables.
SELECT e.employee_name, d.location AS department_location FROM employees e JOIN departments d ON e.department_id = d.department_id;
