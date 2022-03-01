package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NotifyCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(NotifyCommand.class);

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
        double avgGrade = programService.getAvgGrade(student);

        if (avgGrade < Constants.PASSING_SCORE) {
            logger.info("Студент {} {} со средним баллом = {} должен/на быть отчислен",
                    student.getFirstName(), student.getLastName(), avgGrade);
        } else {
            logger.info("Студент {} {} со средним баллом = {} должен/на получить предложение о работе",
                    student.getFirstName(), student.getLastName(), avgGrade);
        }
    }
}
