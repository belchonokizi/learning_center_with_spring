package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PutMarkCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PutMarkCommand.class);

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
        int studentId = helper.askStudentId();
        Student student = studentService.findStudentById(studentId);

        System.out.println("Введите номер темы");
        int moduleId = helper.readInt();

        System.out.println("Введите оценку");
        int mark = helper.readInt();

        Program program = programService.findProgramById(student.getProgramId());
        Module module = program.getModules().stream().filter(m -> m.getId() == moduleId)
                .findFirst().orElseThrow(() -> new NullPointerException("Модуль не найден"));
        student.getMarksMap().put(module.getName(), mark);

        studentService.updateStudent(studentId, student);
        logger.info("Оценка студенту {} {} поставлена", student.getFirstName(), student.getLastName());
    }
}
