package com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.StudentDataExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.lang.Nullable;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

public class JDBCStudentRepository implements IStudentRepository {
    private final Logger logger = LoggerFactory.getLogger(JDBCStudentRepository.class);

    private JdbcTemplate jdbcTemplate;
    private StudentDataExtractor extractor;
    private SqlQueriesReader reader;
    private GeneratedKeyHolder keyHolder;

    public JDBCStudentRepository() {
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setExtractor(StudentDataExtractor extractor) {
        this.extractor = extractor;
    }

    @Autowired
    public void setReader(SqlQueriesReader reader) {
        this.reader = reader;
    }

    @Autowired
    public void setKeyHolder(GeneratedKeyHolder keyHolder) {
        this.keyHolder = keyHolder;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = reader.readSqlQueries(Constants.GET_ALL_STUDENTS_QUERY_PATH);
        return jdbcTemplate.query(query, extractor);
    }

    @Override
    public boolean addStudent(Student student) {
        String query = reader.readSqlQueries(Constants.ADD_STUDENT_QUERY_PATH);
        int rowCount = jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"id"});
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setDate(5, Date.valueOf(student.getStartDate()));
            preparedStatement.setInt(6, student.getProgramId());
            preparedStatement.setInt(7, 0);
            return preparedStatement;
        }, keyHolder);
        student.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return rowCount == 1;
    }

    @Override
    public boolean deleteStudent(int id) {
        String query = reader.readSqlQueries(Constants.DELETE_STUDENT_BY_ID_SQL_QUERY_PATH);
        return jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement;
        }) == 1;
    }

    @Override
    public @Nullable
    Student findStudentById(int id) {
        String query = reader.readSqlQueries(Constants.GET_STUDENT_BY_ID_SQL_QUERY_PATH);
        List<Student> students = jdbcTemplate.query(query, extractor, id);
        Student student = null;
        if (students.isEmpty()) {
            logger.error("Студент не найден");
        } else {
            student = students.get(0);
        }
        return student;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        String query = reader.readSqlQueries(Constants.UPDATE_STUDENT_SQL_QUERY_PATH);
        int rowCount = jdbcTemplate.update(query, student.getFirstName(), studentId);
        return rowCount == 1 ? student : null;
    }
}
