SELECT st.first_name,
       st.last_name,
       c.phone_number,
       c.email
FROM students st JOIN contacts c
                 ON st.id = c.id
WHERE st.first_name = ? AND last_name = ?