package com.ilzirabalobanova.epam.learning_center.shell;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.service.IProgramService;
import com.ilzirabalobanova.epam.learning_center.service.IStudentService;
import com.ilzirabalobanova.epam.learning_center.util.Comparators;
import com.ilzirabalobanova.epam.learning_center.util.Constants;
import com.ilzirabalobanova.epam.learning_center.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class Commands {
    private static final Logger logger = LoggerFactory.getLogger(Commands.class);

    private final IStudentService studentService;
    private final Validator validator;
    private final IProgramService programService;

    @Autowired
    public Commands(IStudentService studentService, Validator validator, IProgramService programService) {
        this.studentService = studentService;
        this.validator = validator;
        this.programService = programService;
    }

    @ShellMethod("add -fn Alex -ln Brown -pi 1")
    public void add(@ShellOption({"-fn", "--firstName"}) String firstName,
                    @ShellOption({"-ln", "--lastName"}) String lastName,
                    @ShellOption({"-pi", "-programId"}) int programId) {
        if (!validator.isNameNonValid(firstName) && !validator.isNameNonValid(lastName) && validator.isIntValid(programId)) {
            studentService.addStudent(new Student(firstName, lastName, programId, new HashMap<>()));
        }
    }

    @ShellMethod("remove -si 1")
    public void remove(@ShellOption({"-si", "--studentId"}) int studentId) {
        studentService.deleteStudent(studentId);
    }

    @ShellMethod("show -sn 1 or 2")
    public void show(@ShellOption({"-sn", "--sortNumber"}) int sortNumber) {
        Comparators comparators = new Comparators();
        switch (sortNumber) {
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

    @ShellMethod("put -si 1 -mi 3 -m 90")
    public void put(@ShellOption({"-si", "--studentId"}) int studentId,
                    @ShellOption({"-mi", "--moduleId"}) int moduleId,
                    @ShellOption({"-m", "--mark"}) int mark) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            Program program = programService.findProgramById(student.getProgramId());
            Module module = program.getModules().stream().filter(m -> m.getId() == moduleId)
                    .findFirst().orElseThrow(() -> new NullPointerException("Модуль не найден"));
            student.getMarksMap().put(module.getName(), mark);

            studentService.updateStudent(studentId, student);
            logger.info("Оценка студенту {} {} поставлена", student.getFirstName(), student.getLastName());
        }
    }

    @ShellMethod("count -si 1")
    public void count(@ShellOption({"-si", "--studentId"}) int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
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
                logger.info("Программа уже завершена");
            } else {
                logger.info("{} - количество дней до окончания программы", countDays);
            }
        }
    }

    @ShellMethod("score -si 1")
    public void score(@ShellOption({"-si", "--studentId"}) int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            double avgGrade = programService.getAvgGrade(student);
            System.out.printf("Успеваемость %s %s %n:", student.getFirstName(), student.getLastName());
            Map<String, Integer> marksMap = student.getMarksMap();
            marksMap.entrySet().forEach(System.out::println);
            System.out.printf("Средний балл = %.2f%n", avgGrade);
        }
    }

    @ShellMethod("filter")
    public void filter() {
        System.out.println("Есть вероятность, что не будут отчислены:");
        studentService.filterAndShowStudents(studentService.getAllStudents());
    }

    @ShellMethod("notify -si 1")
    public void notify(@ShellOption({"-si", "--studentId"}) int studentId) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            double avgGrade = programService.getAvgGrade(student);

            if (avgGrade < Constants.PASSING_SCORE) {
                System.out.printf("Студент %s %s со средним баллом = %.2f должен/на быть отчислен%n",
                        student.getFirstName(), student.getLastName(), avgGrade);
            } else {
                System.out.printf("Студент %s %s со средним баллом = %.2f должен/на получит предложение о работе%n",
                        student.getFirstName(), student.getLastName(), avgGrade);
            }
        }
    }

    @ShellMethod("report")
    public void report() {
        studentService.createReport(Constants.PATH_REPORT, studentService.getAllStudents());
    }
}
