SELECT id, (CASE
WHEN id % 2 = 1 THEN COALESCE(LEAD(student, 1) OVER (ORDER BY id ASC), student)
ELSE LAG(student, 1) OVER (ORDER BY id ASC)
END) as student
FROM Seat
