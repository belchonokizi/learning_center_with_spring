package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateReportCommand implements Command {
    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        studentService.createReport(Constants.PATH_REPORT, studentService.getAllStudents());
    }

    @Override
    public String toString() {
        return "createReportCommand";
    }
}
