package com.ilzirabalobanova.epam.learning_center.controller;

import com.ilzirabalobanova.epam.learning_center.entity.Mark;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IMarkService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;
    private final IMarkService markService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId) {
        return studentService.findStudentById(studentId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Student saveNewStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable Integer studentId) {
        if (!studentService.deleteStudent(studentId)) {
            return "Ошибка в удалении студента";
        }
        return "Студент удален";
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @GetMapping("/score/{studentId}")
    public List<Mark> getStudentScoreById(@PathVariable Integer studentId) {
        return markService.findStudentMarks(studentId);
    }

    @PutMapping("/score/{studentId}/{moduleId}/{value}")
    public void updateScore(@PathVariable Integer studentId, @PathVariable Integer moduleId, @PathVariable Integer value) {
        markService.updateMark(studentId, moduleId, value);
    }

    @PostMapping("/score/{studentId}/{moduleId}/{value}")
    public void putNewScore(@PathVariable Integer studentId, @PathVariable Integer moduleId, @PathVariable Integer value) {
        markService.putNewMark(studentId, moduleId, value);
    }

    @PostMapping("/programs/join/{studentId}/{programId}")
    public void joinTheProgram(@PathVariable Integer studentId, @PathVariable Integer programId) {
        studentService.joinTheProgram(studentId, programId);
    }
}
