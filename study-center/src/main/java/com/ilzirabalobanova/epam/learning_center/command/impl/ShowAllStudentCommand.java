package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Comparators;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShowAllStudentCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(ShowAllStudentCommand.class);

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute() {
        ConsoleHelper helper = new ConsoleHelper();
        Comparators comparators = new Comparators();
        System.out.println("Выберите вид сортировки:");
        System.out.printf("\t %d - по id %n", 1);
        System.out.printf("\t %d - по фамилии %n", 2);
        int choice = helper.readInt();
        switch (choice) {
            case 1:
                studentService.sortAndShowStudents(comparators.getSortById(), studentService.getAllStudents());
                break;
            case 2:
                studentService.sortAndShowStudents(comparators.getSortByLastName(), studentService.getAllStudents());
                break;
            default:
                logger.error("Вы выбрали неверную комманду");
        }
    }

    @Override
    public String toString() {
        return "showAllStudentCommand";
    }
}
