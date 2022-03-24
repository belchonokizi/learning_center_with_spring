package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

public class FilterCommand implements Command {
    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        System.out.println("Есть вероятность, что не будут отчислены:");
        studentService.filterAndShowStudents(studentService.getAllStudents(Constants.GET_ALL_STUDENTS_QUERY_PATH));
    }

    @Override
    public String toString() {
        return "filterCommand";
    }
}
