# Write your MySQL query statement below
SELECT 
    student_exams.student_id,  student_exams.student_name, student_exams.subject_name, COUNT(Examinations.subject_name) AS attended_exams
FROM 
    (
        SELECT student_id, student_name, subject_name
        FROM Students, Subjects
        ORDER BY student_id
    ) student_exams
LEFT JOIN
    Examinations ON 
        student_exams.student_id = Examinations.student_id
            AND
        student_exams.subject_name = Examinations.subject_name
GROUP BY student_exams.student_id, student_exams.subject_name
ORDER BY student_exams.student_id, student_exams.subject_name