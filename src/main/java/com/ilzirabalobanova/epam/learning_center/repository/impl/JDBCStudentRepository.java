package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@ConditionalOnClass(DataSource.class)
public class JDBCStudentRepository implements IStudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
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
