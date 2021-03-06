package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IStudentRepository;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;
    private final IProgramService programService;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
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
            log.error("???????????? ???????????? ???????????? ?? ?????????? {}", e.getMessage());
        }
    }
    @Override
    public void joinTheProgram(int studentId, int programId) {
        studentRepository.joinTheProgram(studentId, programId);
    }
}
