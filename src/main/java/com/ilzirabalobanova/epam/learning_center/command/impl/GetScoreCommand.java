package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class GetScoreCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(GetScoreCommand.class);

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
        logger.info("\nУспеваемость {} {} :", student.getFirstName(), student.getLastName());
        Map<String, Integer> marksMap = student.getMarksMap();
        marksMap.entrySet().forEach(System.out::println);
        logger.info("Средний балл = {}", avgGrade);
    }
}
