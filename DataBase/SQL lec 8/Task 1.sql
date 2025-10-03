-- NATURAL JOIN 
SELECT *
FROM locations l
NATURAL JOIN countries c;

-- JOIN using USING keyword with column COUNTRY_ID
SELECT *
FROM locations l
JOIN countries c
USING (country_id);

-- JOIN using ON keyword with column COUNTRY_ID
SELECT *
FROM locations l
JOIN countries c
ON l.country_id = c.country_id;

-- INNER JOIN (explicit form, same result as JOIN)
SELECT *
FROM locations l
INNER JOIN countries c
ON l.country_id = c.country_id;

-- LEFT OUTER JOIN 
-- (all rows from LOCATIONS even if no match in COUNTRIES)
SELECT *
FROM locations l
LEFT JOIN countries c
ON l.country_id = c.country_id;

-- RIGHT OUTER JOIN 
-- (all rows from COUNTRIES even if no match in LOCATIONS)
SELECT *
FROM locations l
RIGHT JOIN countries c
ON l.country_id = c.country_id;

-- FULL OUTER JOIN 
-- (all rows from both LOCATIONS and COUNTRIES, matched or not)
SELECT *
FROM locations l
FULL JOIN countries c
ON l.country_id = c.country_id;
