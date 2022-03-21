package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IMarkService;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PutMarkCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PutMarkCommand.class);

    private IStudentService studentService;
    private IMarkService markService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setMarkService(IMarkService markService) {
        this.markService = markService;
    }

    @Override
    public void execute() {
        ConsoleHelper helper = new ConsoleHelper();
        int studentId = helper.askStudentId();
        Student student = studentService.findStudentById(studentId);

        if (student != null) {
            System.out.println("Введите номер темы");
            int moduleId = helper.readInt();

            System.out.println("Введите оценку");
            int mark = helper.readInt();

            markService.updateMark(studentId, moduleId, mark);

            studentService.updateStudent(studentId, student);
            logger.info("Оценка студенту {} {} поставлена", student.getFirstName(), student.getLastName());
        }
    }

    @Override
    public String toString() {
        return "putMarkCommand";
    }
}
