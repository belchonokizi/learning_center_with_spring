package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateReportCommand implements Command {
    private final IStudentService studentService;

    @Autowired
    public CreateReportCommand(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        studentService.createReport(Constants.PATH_REPORT, studentService.getAllStudents());
    }
}
