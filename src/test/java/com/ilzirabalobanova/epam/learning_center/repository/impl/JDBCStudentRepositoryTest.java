package com.ilzirabalobanova.epam.learning_center.repository.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/students-schema.sql", "/students-test-data.sql"})
class JDBCStudentRepositoryTest {
    @Autowired
    private JDBCStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/get-students.sql"})
    void getAllStudents(String path) {
        assertEquals(5, studentRepository.getAllStudents(path).size());
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