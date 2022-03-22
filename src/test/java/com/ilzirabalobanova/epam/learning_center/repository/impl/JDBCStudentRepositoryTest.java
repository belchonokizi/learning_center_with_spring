package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/students-schema.sql", "/students-test-data.sql"})
class JDBCStudentRepositoryTest {
    @Autowired
    private JDBCStudentRepository studentRepository;

    private final Student student1 = new Student(1, "Ivan", "Gorin", "89120253064", "sdfghjk", LocalDate.of(2022, 12, 3), false, new Program(1, null, null), List.of());
    private final Student student2 = new Student(2, "Anna", "Grushina", "89240266064", "f", LocalDate.of(2022, 10, 3), false, new Program(2, null, null), List.of());
    private final Student student3 = new Student(3, "Elena", "Sovina", "89360253048", "fff", LocalDate.of(2022, 11, 3), false, new Program(3, null, null), List.of());
    private final Student student4 = new Student(4, "Igor", "Balin", "89500250064", "sd", LocalDate.of(2022, 9, 3), false, new Program(4, null, null), List.of());
    private final Student student5 = new Student(5, "Aleksandr", "Tutin", "89990253784", "dd", LocalDate.of(2022, 8, 3), false, new Program(5, null, null), List.of());
    private final Student student6 = new Student("Boris", "Sidorov", "89120183064", "boris", LocalDate.of(2021, 12, 3), false, new Program(6, null, null), List.of());

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/students/get-students.sql"})
    void getAllStudents(String path) {
        List<Student> allStudents = studentRepository.getAllStudents(path);
        assertEquals(5, allStudents.size());
        assertThat(allStudents, hasItem(student1));
        assertThat(allStudents, hasItem(student2));
        assertThat(allStudents, hasItem(student3));
        assertThat(allStudents, hasItem(student4));
        assertThat(allStudents, hasItem(student5));
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/students/add-student.sql," +
            "src/test/resources/students/get-student-by-id.sql"})
    void addStudent(String path1, String path2) {
        assertTrue(studentRepository.addStudent(student6, path1));
        Student result = studentRepository.findStudentById(6, path2);
        assertEquals(student6, result);
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/students/delete-student.sql," +
            "src/test/resources/students/get-student-by-id.sql"})
    void deleteStudent(String path1, String path2) {
        assertTrue(studentRepository.deleteStudent(1, path1));
        Student result = studentRepository.findStudentById(1, path2);
        assertNull(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/students/get-student-by-id.sql"})
    void findStudentById(String path) {
        Student result = studentRepository.findStudentById(1, path);
        assertEquals(student1, result);
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/students/update-student.sql," +
            "src/test/resources/students/get-student-by-id.sql"})
    void updateStudent(String path1, String path2) {
        Student newStudent = studentRepository.updateStudent(1, student6, path1);
        Student updatedStudent = studentRepository.findStudentById(1, path2);
        assertEquals(newStudent.getFirstName(), updatedStudent.getFirstName());
        assertEquals(student1.getLastName(), updatedStudent.getLastName());
    }
}