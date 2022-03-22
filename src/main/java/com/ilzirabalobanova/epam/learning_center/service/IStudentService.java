package com.ilzirabalobanova.epam.learning_center.service;


import com.ilzirabalobanova.epam.learning_center.entity.Student;

import java.util.Comparator;
import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents(String path);

    boolean addStudent(Student student, String path);

    boolean deleteStudent(int id, String path);

    void showAllStudents(List<Student> studentList);

    List<Student> sortAndShowStudents(Comparator<Student> comparator, List<Student> list);

    Student findStudentById(int id, String path);

    Student updateStudent(int studentId, Student student, String path);

    List<Student> filterAndShowStudents(List<Student> studentList);

    void createReport(String path, List<Student> list);


}

