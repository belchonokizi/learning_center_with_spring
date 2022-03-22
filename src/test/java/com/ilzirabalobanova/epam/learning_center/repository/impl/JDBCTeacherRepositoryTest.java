package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Sql({"/teachers/teachers-schema.sql", "/teachers/teachers-test-data.sql"})
class JDBCTeacherRepositoryTest {
    @Autowired
    private JDBCTeacherRepository teacherRepository;

    private final Teacher teacher1 = new Teacher(1, "Mikhail", "Petrov", "middle");
    private final Teacher teacher2 = new Teacher(2, "Irina", "Shubina", "senior");
    private final Teacher teacher3 = new Teacher(3, "Petr", "Sokolov", "senior");

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/teachers/get-all-teachers.sql"})
    void getAllTeachers(String path) {
        List<Teacher> teacherList = teacherRepository.getAllTeachers(path);
        assertThat(teacherList, hasSize(2));
        assertThat(teacherList, hasItem(teacher1));
        assertThat(teacherList, hasItem(teacher2));
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/teachers/add-teacher.sql," +
            "src/test/resources/teachers/find-teacher-by-id.sql"})
    void addTeacher(String path1, String path2) {
        assertTrue(teacherRepository.addTeacher(teacher3, path1));
        Teacher result = teacherRepository.findTeacherById(3, path2);
        assertEquals(teacher3, result);
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/teachers/delete-teacher.sql," +
            "src/test/resources/teachers/find-teacher-by-id.sql"})
    void deleteTeacher(String path1, String path2) {
        assertTrue(teacherRepository.deleteTeacher(1, path1));
        Teacher result = teacherRepository.findTeacherById(1, path2);
        assertNull(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/teachers/find-teacher-by-id.sql"})
    void findTeacherById(String path) {
        Teacher teacher = teacherRepository.findTeacherById(1, path);
        assertEquals(teacher1, teacher);
    }
}