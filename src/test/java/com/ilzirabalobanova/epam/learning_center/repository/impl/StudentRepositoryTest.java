package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/students/students-schema.sql", "/students/students-test-data.sql"})
class StudentRepositoryTest {
    @Autowired
    private IStudentRepository studentRepository;

    private final Student student1 = new Student(1, "Ivan", "Gorin", "89120253064", "sdfghjk", LocalDate.of(2022, 12, 3), false, 1);
    private final Student student2 = new Student(2, "Anna", "Grushina", "89240266064", "f", LocalDate.of(2022, 10, 3), false, 2);
    private final Student student3 = new Student(3, "Elena", "Sovina", "89360253048", "fff", LocalDate.of(2022, 11, 3), false, 3);
    private final Student student4 = new Student( "Boris", "Sidorov", "89120183064", "boris", LocalDate.of(2021, 12, 3), false, 4);

    @Test
    void addStudent() {
        assertTrue(studentRepository.addStudent(student4));
        Student result = studentRepository.findStudentById(4);
        assertEquals(student4, result);
    }

    @Test
    void getAllStudents() {
        List<Student> allStudents = studentRepository.getAllStudents();
        allStudents.forEach(System.out::println);
        assertEquals(3, allStudents.size());
        assertThat(allStudents, hasItem(student1));
        assertThat(allStudents, hasItem(student2));
        assertThat(allStudents, hasItem(student3));
    }

    @Test
    void deleteStudent() {
        assertTrue(studentRepository.deleteStudent(1));
        Student result = studentRepository.findStudentById(1);
        assertNull(result);
    }

    @Test
    void findStudentById() {
        Student result = studentRepository.findStudentById(1);
        assertEquals(student1, result);
    }

    @Test
    void updateStudent() {
        Student newStudent = studentRepository.updateStudent(1, student4);
        Student updatedStudent = studentRepository.findStudentById(1);
        assertEquals(newStudent.getFirstName(), Objects.requireNonNull(updatedStudent).getFirstName());
        assertEquals(student1.getLastName(), updatedStudent.getLastName());
    }
}