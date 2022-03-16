SELECT st.id AS student_id,
	   st.first_name,
       st.last_name,
       pr.id             AS program_id,
       pr.name           AS program_name,
       m.id              AS module_id,
       m.name            AS module_name,
       m.duration        AS module_duration,
       mark.value        AS mark_value,
       c.phone_number,
       c.email
FROM students st
		JOIN programs pr ON st.program_id = pr.id
		JOIN modules m ON pr.id = m.program_id
		JOIN marks mark ON st.id = mark.student_id and m.id = mark.module_id
		JOIN contacts c ON st.id = c.id
WHERE st.id = ?;
