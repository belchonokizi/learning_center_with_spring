package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoveCommand implements Command {
    private final Logger logger = LoggerFactory.getLogger(RemoveCommand.class);

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        ConsoleHelper helper = new ConsoleHelper();
        int id = helper.askStudentId();
        if (studentService.deleteStudent(id)) {
            logger.info("Студент удален");
        } else {
            logger.error("Студент не найден");
        }
    }

    @Override
    public String toString() {
        return "removeCommand";
    }
}
