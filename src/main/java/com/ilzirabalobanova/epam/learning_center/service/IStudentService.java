package com.ilzirabalobanova.epam.learning_center.service;


import com.ilzirabalobanova.epam.learning_center.entity.Student;

import java.util.Comparator;
import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student deleteStudent(int id);

    void showAllStudents(List<Student> studentList);

    List<Student> sortAndShowStudents(Comparator<Student> comparator, List<Student> list);

    Student findStudentById(int id);

    Student updateStudent(int studentId, Student student);

    List<Student> filterAndShowStudents(List<Student> studentList);

    void createReport(String path, List<Student> list);


}

