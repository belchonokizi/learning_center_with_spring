package com.ilzirabalobanova.epam.learning_center.command.impl;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import com.ilzirabalobanova.epam.learning_center.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class AddCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddCommand.class);

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
        Validator validator = new Validator(programService);
        ConsoleHelper helper = new ConsoleHelper();
        String name;
        do {
            System.out.println("Введите имя студента");
            name = helper.readString();
        } while (validator.isNameNonValid(name));

        String lastName;
        do {
            System.out.println("Введите фамилию студента");
            lastName = helper.readString();
        } while (validator.isNameNonValid(lastName));

        String phoneNumber;
        do {
            System.out.println("Введите номер телефона:");
            phoneNumber = helper.readString();
        } while (phoneNumber.equals(""));

        String email;
        do {
            System.out.println("Введите email:");
            email = helper.readString();
        } while (email.equals(""));

        int programId;
        do {
            System.out.println("Введите номер программы:");
            int count = 1;
            for (Program program : programService.getAllPrograms()) {
                System.out.printf("%d - %s%n", count, program.getName());
                count++;
            }
            programId = helper.readInt();
        } while (!validator.isIntValid(programId));

        Student student = new Student(name, lastName, phoneNumber, email, LocalDate.now(), false, 1);
        if (studentService.addStudent(student)) {
            logger.info("Студент {} {} добавлен", student.getFirstName(), student.getLastName());
        } else {
            logger.error("Ошибка добавления студента");
        }
    }

    @Override
    public String toString() {
        return "addCommand";
    }
}

