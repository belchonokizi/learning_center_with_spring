package com.ilzirabalobanova.epam.learning_center.repository;

import com.ilzirabalobanova.epam.learning_center.entity.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> getAllStudents(String path);

    boolean addStudent(Student student, String path);

    boolean deleteStudent(int id, String path);

    Student findStudentById(int id, String path);

    Student updateStudent(int studentId, Student student, String path);

}
