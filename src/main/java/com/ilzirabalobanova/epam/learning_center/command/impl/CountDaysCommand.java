package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CountDaysCommand implements Command {
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
        Program program = programService.findProgramById(student.getProgramId());
        long wholeDuration = program.getModules().stream().map(Module::getDurationInHours).mapToLong(m -> m).sum();
        long currentDuration = 0;

        for (Map.Entry<String, Integer> pair : student.getMarksMap().entrySet()) {
            Module module = program.getModules().stream().filter(m -> m.getName().equals(pair.getKey())).findFirst()
                    .orElseThrow(() -> new NullPointerException("Модуль не найден"));
            currentDuration += module.getDurationInHours();
        }

        int countDays = (int) Math.ceil((wholeDuration - currentDuration) / Constants.HOURS_IN_DAY);
        if (countDays == 0) {
            System.out.println("Программа уже завершена");
        } else {
            System.out.printf("%d - количество дней до окончания программы", countDays);
        }
    }

    @Override
    public String toString() {
        return "countDaysCommand";
    }
}
