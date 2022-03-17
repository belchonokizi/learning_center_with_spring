SELECT st.id AS student_id,
	   st.first_name,
       st.last_name,
       pr.id             AS program_id,
       pr.name           AS program_name,
       st.phone_number,
       st.email,
       st.is_finished_program
FROM students st
		JOIN programs pr ON st.program_id = pr.id
WHERE st.id = 1;

