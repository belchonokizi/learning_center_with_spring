DROP TABLE IF EXISTS students;

CREATE TABLE students (
 id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(255) NOT NULL,
 last_name VARCHAR(255) NOT NULL,
 phone_number VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 start_date DATE,
 is_finished_program TINYINT,
 program_id INT NOT NULL
)