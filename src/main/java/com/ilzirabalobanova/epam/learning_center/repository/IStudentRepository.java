package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;

import java.util.List;

public interface IStudentRepository {

    List<Student> getAllStudents();

    void addStudent(Student student);

    void deleteStudent(int id) throws IllegalInitialDataException;

    Student findStudentById(int id) throws IllegalInitialDataException;

    Student updateStudent(int studentId, Student student);

}
