package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final IStudentRepository studentRepository;
    private final IProgramService programService;

    @Autowired
    public StudentService(IStudentRepository studentRepository, IProgramService programService) {
        this.studentRepository = studentRepository;
        this.programService = programService;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public Student deleteStudent(int id) {
         return studentRepository.deleteStudent(id);
    }

    @Override
    public void showAllStudents(List<Student> studentList) {
        studentList.forEach(System.out::println);
    }

    @Override
    public List<Student> sortAndShowStudents(Comparator<Student> comparator, List<Student> list) {
        list = list.stream().sorted
                (comparator).collect(Collectors.toList());
        showAllStudents(list);
        return list;
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Student updateStudent(int index, Student student) {
        return studentRepository.updateStudent(index, student);
    }

    @Override
    public List<Student> filterAndShowStudents(List<Student> studentList) {
        List<Student> students = studentList.stream().filter(student -> programService.getAvgGrade(student) >= Constants.PASSING_SCORE)
                .collect(Collectors.toList());
        students.forEach(System.out::println);
        return students;
    }

    @Override
    public void createReport(String path, List<Student> list) {
        try {
            new WriteReportService().writeInFile(path, list);
        } catch (IOException e) {
            logger.error("Ошибка записи отчета в файла {}", e.getMessage());
        }
    }
}
