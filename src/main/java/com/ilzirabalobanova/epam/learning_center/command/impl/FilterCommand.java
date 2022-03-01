package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class FilterCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(FilterCommand.class);

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        logger.info("\nЕсть вероятность, что не будут отчислены:");
        studentService.filterAndShowStudents(studentService.getAllStudents());
    }
}
