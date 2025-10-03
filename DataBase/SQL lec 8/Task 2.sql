-- NATURAL JOIN 
SELECT *
FROM jobs j
NATURAL JOIN job_history;

-- JOIN using USING keyword with column JOB_ID
SELECT *
FROM jobs j
JOIN job_history h
USING (job_id);

-- JOIN using ON keyword with column JOB_ID
SELECT *
FROM jobs j
JOIN job_history h
ON j.job_id = h.job_id;

-- INNER JOIN 
SELECT *
FROM jobs j
INNER JOIN job_history h
ON j.job_id = h.job_id;

-- LEFT OUTER JOIN 
-- (all JOBS even if no match in JOB_HISTORY)
SELECT *
FROM jobs j
LEFT JOIN job_history h
ON j.job_id = h.job_id;

-- RIGHT OUTER JOIN 
-- (all JOB_HISTORY rows even if no match in JOBS)
SELECT *
FROM jobs j
RIGHT JOIN job_history h
ON j.job_id = h.job_id;

-- FULL OUTER JOIN 
-- (all JOBS and all JOB_HISTORY rows, matched or not)
SELECT *
FROM jobs j
FULL JOIN job_history h
ON j.job_id = h.job_id;
