package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.repository.impl.StudentRepository;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;
    private final Student student = new Student(1, "Борис", "Тютин", 2, new HashMap<>());
    private final Student student2 = new Student(2, "Алиса", "Селезнёва", 1,
            Map.of("first", 100, "second", 100, "third", 100));
    private final Student student3 = new Student(3, "Виталий", "Гаврилов", 2,
            Map.of("firstModule", 80, "second", 90, "third", 100));
    private final Student student4 = new Student(4, "Зоя", "Суворова", 3,
            Map.of("first", 70, "second", 60, "third", 60));
    private final List<Student> list = new ArrayList<>();

    @Mock
    private StudentFileParser parser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addStudentsToList();
        Mockito.when(parser.getStudents(Mockito.anyString())).thenReturn(list);
        this.studentRepository = new StudentRepository(parser);
    }

    @AfterEach
    void clearList() {
        list.clear();
    }

    @Test
    void addStudent() throws IllegalInitialDataException {
        studentRepository.addStudent(student2);

        assertEquals(4, studentRepository.getAllStudents().size());
        assertEquals(student2, studentRepository.findStudentById(student2.getId()));
    }

    @Test
    void deleteStudent() throws IllegalInitialDataException {
        studentRepository.deleteStudent(1);
        assertEquals(2, list.size());
        IllegalInitialDataException exception = assertThrows(IllegalInitialDataException.class, () -> {
            studentRepository.findStudentById(1);
        });
        assertEquals("Студент с id = 1 не найден", exception.getMessage());
    }

    @Test
    void findStudentById() throws IllegalInitialDataException {
        Student foundedStudent = studentRepository.findStudentById(1);
        assertEquals(student, foundedStudent);
    }

    @Test
    void updateStudent() {
        Student newStudent = new Student(1, "Ivan", "Ivanov", 1, Map.of());
        Student updatedStudent = studentRepository.updateStudent(1, newStudent);
        assertEquals(newStudent, updatedStudent);
    }

    private void addStudentsToList() {
        list.add(student3);
        list.add(student);
        list.add(student4);
    }
}