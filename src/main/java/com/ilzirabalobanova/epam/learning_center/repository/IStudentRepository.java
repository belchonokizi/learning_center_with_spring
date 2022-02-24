package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student deleteStudent(int id);

    Student findStudentById(int id);

    Student updateStudent(int studentId, Student student);

}
