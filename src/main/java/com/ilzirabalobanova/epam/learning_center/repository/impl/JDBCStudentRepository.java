package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.StudentDataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("jdbcStudentRepository")
@ConditionalOnClass(DataSource.class)
public class JDBCStudentRepository implements IStudentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final StudentDataExtractor extractor;
    private final SqlQueriesReader reader;

    @Autowired
    public JDBCStudentRepository(JdbcTemplate jdbcTemplate, StudentDataExtractor extractor, SqlQueriesReader reader) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
        this.reader = reader;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = reader.readSqlQueries(Constants.GET_ALL_STUDENTS_QUERY_PATH);
        return jdbcTemplate.query(query, extractor);
    }

    @Override
    public boolean addStudent(Student student) {
        return false;
    }

    @Override
    public Student deleteStudent(int id) {
        return null;
    }

    @Override
    public Student findStudentById(int id) {
        return null;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return null;
    }
}
