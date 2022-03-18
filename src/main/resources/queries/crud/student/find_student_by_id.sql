SELECT st.id AS student_id,
st.first_name AS first_name,
st.last_name AS last_name,
st.phone_number AS phone_number,
st.email AS email,
st.start_date AS start_date,
st.is_finished_program AS is_finished_program,
pr.id AS program_id,
pr.name AS program_name,
m.id AS module_id,
m.name AS module_name,
m.duration AS module_duration,
mark.id AS mark_id,
mark.value AS mark_value
 FROM students st JOIN programs pr ON st.program_id = pr.id
 JOIN modules m ON pr.id = m.program_id
 JOIN marks mark ON st.id = mark.student_id and m.id = mark.module_id
 WHERE st.id = ?

