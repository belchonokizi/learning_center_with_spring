package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.util.SqlQueriesReader;
import com.ilzirabalobanova.epam.learning_center.util.extractors.StudentDataExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Sql({"/students-schema.sql", "/students-test-data.sql"})
class JDBCStudentRepositoryTest {
    private JDBCStudentRepository studentRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Mock
    private StudentDataExtractor extractor;

    @Mock
    private SqlQueriesReader reader;

    @Mock
    private GeneratedKeyHolder keyHolder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.studentRepository = new JDBCStudentRepository(jdbcTemplate, extractor, reader, keyHolder);
    }

    @Test
    void getAllStudents() {
        assertEquals(5, studentRepository.getAllStudents().size());
    }

    @Test
    void addStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void findStudentById() {
    }

    @Test
    void updateStudent() {
    }
}