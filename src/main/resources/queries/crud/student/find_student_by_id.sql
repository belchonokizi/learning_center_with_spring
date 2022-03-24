SELECT st.id AS student_id,
st.first_name AS first_name,
st.last_name AS last_name,
st.phone_number AS phone_number,
st.email AS email,
st.start_date AS start_date,
st.id AS program_id,
st.is_finished_program AS is_finished_program
 FROM students st WHERE ID = ?

