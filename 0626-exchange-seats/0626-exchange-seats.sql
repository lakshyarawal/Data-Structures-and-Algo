# Write your MySQL query statement below
with all_students as(
    SELECT
        LEAD(student) OVER (ORDER BY id ASC) AS next_student,
        LAG(student) OVER (ORDER BY id ASC) AS prev_student,
        student,
        id
    FROM
        Seat
)
SELECT
    id,
    (CASE
        WHEN id % 2 = 1 AND id = (SELECT COUNT(*) FROM Seat) THEN student
        WHEN id % 2 = 1 THEN next_student
        ELSE prev_student
     END) as student
FROM 
    all_students
    
    

