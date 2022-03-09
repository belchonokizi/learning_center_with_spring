package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class GetScoreCommand implements Command {

    private IStudentService studentService;
    private IProgramService programService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setProgramService(IProgramService programService) {
        this.programService = programService;
    }

    @Override
    public void execute() {
        ConsoleHelper helper = new ConsoleHelper();
        int id = helper.askStudentId();
        Student student = studentService.findStudentById(id);

        if (student != null) {
            double avgGrade = programService.getAvgGrade(student);
            System.out.printf("Успеваемость %s %s :", student.getFirstName(), student.getLastName());
            Map<String, Integer> marksMap = student.getMarksMap();
            marksMap.entrySet().forEach(System.out::println);
            System.out.printf("Средний балл = %.2f", avgGrade);
        }
    }

    @Override
    public String toString() {
        return "getScoreCommand";
    }
}
