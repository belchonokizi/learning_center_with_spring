package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.service.impl.StudentService;
import com.ilzirabalobanova.epam.learning_center.util.Comparators;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IProgramRepository programRepository;

    private IStudentService studentService;

    private final Student student = new Student(1, "Boris", "Sidorov", 2, Map.of());
    private final Student student2 = new Student(2, "Alisa", "Shmel", 1,
            Map.of("first", 100, "second", 100, "third", 100));
    private final Student student3 = new Student(3, "Elena", "Grushina", 3,
            Map.of("first", 70, "second", 80, "third", 90));
    private final List<Student> list = new ArrayList<>();

    @BeforeEach
    public void setUp() throws IllegalInitialDataException {
        addStudentsToList();
        MockitoAnnotations.openMocks(this);
        Mockito.when(studentRepository.findStudentById(1)).thenReturn(student);
        this.studentService = new StudentService(studentRepository, programRepository);
    }

    @AfterEach
    public void clearList() {
        list.clear();
    }

    @Test
    void addStudent() {
        studentService.addStudent(student2);
        Mockito.verify(studentRepository).addStudent(student2);
    }

    @Test
    void deleteStudent() throws IllegalInitialDataException {
        studentService.deleteStudent(1);
        Mockito.verify(studentRepository).deleteStudent(1);
    }

    @Test
    void showAndSortById() {
        List<Student> sortedList = studentService.sortAndShowStudents(new Comparators().getSortById(), list);
        list.sort(Comparator.comparingLong(Student::getId));
        assertEquals(list, sortedList);
    }

    @Test
    void showAndSortByLastName() {
        List<Student> sortedList = studentService.sortAndShowStudents(new Comparators().getSortByLastName(), list);
        list.sort(Comparator.comparing(Student::getLastName));
        assertEquals(list, sortedList);
    }

    @Test
    void findStudentById() throws IllegalInitialDataException {
        Student result = studentService.findStudentById(1);
        assertEquals(student, result);
    }

    @Test
    void updateStudent()  {
        studentService.updateStudent(1, student);
        Mockito.verify(studentRepository).updateStudent(1, student);
    }

    @Test
    void filterStudents() {
        List<Student> students = studentService.filterAndShowStudents(list);
        assertThat(students, hasSize(2));
        assertThat(students, hasItem(student2));
        assertThat(students, hasItem(student3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"src\\test\\resources\\report.txt"})
    void createReport(String pathString) throws IOException {
        final int linesCount = 27;
        Path path = Paths.get(pathString);

        studentService.createReport(pathString, list);
        List<String> lines = Files.readAllLines(path);

        assertTrue(Files.exists(path));
        assertEquals("txt", FilenameUtils.getExtension(pathString));
        assertEquals(linesCount, lines.size());
        assertTrue(lines.get(1).contains("\"firstName\" : \"Elena\","));
        assertTrue(lines.get(2).contains("\"lastName\" : \"Grushina\","));
        assertTrue(lines.get(11).contains("\"firstName\" : \"Alisa\","));
        assertTrue(lines.get(12).contains("\"lastName\" : \"Shmel\","));
    }

    private void addStudentsToList() {
        list.add(student3);
        list.add(student2);
        list.add(student);
    }
}