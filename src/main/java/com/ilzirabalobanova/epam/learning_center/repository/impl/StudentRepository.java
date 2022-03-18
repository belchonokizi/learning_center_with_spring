package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class StudentRepository implements IStudentRepository {
    private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
    private final StudentFileParser parser;
    private List<Student> studentDatabase;

    public StudentRepository(StudentFileParser parser) {
        this.parser = parser;
    }

//    @PostConstruct
//    public void init() {
//        studentDatabase = parser.getStudents(Constants.PATH_STUDENT_FILE);
//    }

    public List<Student> getAllStudents() {
        return studentDatabase;
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDatabase.add(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            studentDatabase.remove(student);
            logger.info("Студент {} {} удален", student.getFirstName(), student.getLastName());
        }
        return student != null;
    }

    @Override
    public Student findStudentById(int id) {
        String s = "Студент с id = " + id + " не найден";
        Student student = null;
        try {
            student = studentDatabase.stream().filter(st -> st.getId() == id)
                    .findFirst().orElseThrow(() -> new IllegalInitialDataException(s));
        } catch (IllegalInitialDataException e) {
            logger.error("Студент с id {} не найден", id);
        }
        return student;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        Student oldStudent = findStudentById(studentId);
        if (student != null) {
            studentDatabase.set(studentDatabase.indexOf(oldStudent), student);
        }
        return student;
    }
}