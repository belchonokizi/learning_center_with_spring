package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/students-schema.sql", "/students-test-data.sql"})
class JDBCStudentRepositoryTest {
    @Autowired
    private JDBCStudentRepository studentRepository;

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/get-students.sql"})
    void getAllStudents(String path) {
        List<Student> allStudents = studentRepository.getAllStudents(path);
        assertEquals(5, allStudents.size());
        assertThat(allStudents, hasItem(new Student(1, "Ivan", "Gorin", "89120253064","sdfghjk", LocalDate.of(2022, 12, 3), false, new Program(1, null, null), List.of())));
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