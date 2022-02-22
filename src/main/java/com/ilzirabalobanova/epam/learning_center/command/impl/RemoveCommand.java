package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(RemoveCommand.class);

    private final IStudentService studentService;

    @Autowired
    public RemoveCommand(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() throws IllegalInitialDataException {
        ConsoleHelper helper = new ConsoleHelper();
        int id = helper.askStudentId();
        studentService.deleteStudent(id);
        logger.info("Студент с id = {} удален", id);
    }
}
