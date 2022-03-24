package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCTeacherRepository;
import org.junit.jupiter.api.Test;
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

    @Test
    void getAllTeachers() {
        List<Teacher> teacherList = teacherRepository.getAllTeachers();
        assertThat(teacherList, hasSize(2));
        assertThat(teacherList, hasItem(teacher1));
        assertThat(teacherList, hasItem(teacher2));
    }

    @Test
    void addTeacher() {
        assertTrue(teacherRepository.addTeacher(teacher3, 1));
        Teacher result = teacherRepository.findTeacherById(3);
        assertEquals(teacher3, result);
    }

    @Test
    void deleteTeacher() {
        assertTrue(teacherRepository.deleteTeacher(1));
        Teacher result = teacherRepository.findTeacherById(1);
        assertNull(result);
    }

    @Test
    void findTeacherById() {
        Teacher teacher = teacherRepository.findTeacherById(1);
        assertEquals(teacher1, teacher);
    }
}