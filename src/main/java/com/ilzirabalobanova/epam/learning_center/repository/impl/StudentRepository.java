package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private final StudentFileParser parser;
    private List<Student> studentDatabase;

    @Autowired
    public StudentRepository(StudentFileParser parser) {
        this.parser = parser;
    }

    @PostConstruct
    public void init() {
        studentDatabase = parser.getStudents(Constants.PATH_STUDENT_FILE);
    }

    public List<Student> getAllStudents() {
        return studentDatabase;
    }

    @Override
    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    @Override
    public void deleteStudent(int id) throws IllegalInitialDataException {
        Student student = findStudentById(id);
        studentDatabase.remove(student);
    }

    @Override
    public Student findStudentById(int id) throws IllegalInitialDataException {
        String s = "Студент с id = " + id + " не найден";
        return studentDatabase.stream().filter(st -> st.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalInitialDataException(s));
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        Student oldStudent = studentDatabase.stream().filter(s -> s.getId() == studentId).findFirst()
                .orElseThrow(() -> new NullPointerException("Студент не найден"));
        studentDatabase.set(studentDatabase.indexOf(oldStudent), student);
        return student;

    }
}