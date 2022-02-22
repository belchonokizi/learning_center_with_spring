package com.ilzirabalobanova.epam.learning_center.operation;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.command.impl.CommandFactory;
import org.springframework.stereotype.Component;

@Component
public enum Operation {
    ADD("Добавить студента",
            CommandFactory.createAddCommand()),
    REMOVE("Удалить студента",
            CommandFactory.createRemoveCommand()),
    PUT_MARK("Поставить оценку за тест по теме",
            CommandFactory.createPutMarkCommand()),
    COUNT_DAYS("Рассчитать количество дней до завершения программы",
            CommandFactory.createCountDaysCommand()),
    GET_SCORE("Рассчитать и вывести отчет об успеваемости",
            CommandFactory.createGetScoreCommand()),
    NOTIFY_ABOUT_EXCLUSION("Рассчитать возможность отчисления студента",
            CommandFactory.createNotifyCommand()),
    SHOW_ALL_STUDENTS("Просмотреть список всех студентов",
            CommandFactory.createShowAllStudentsCommand()),
    FILTER("Фильтровать список студентов по условию \"Есть вероятность, что не будет отчислен\"",
            CommandFactory.createFilterCommand()),
    CREATE_REPORT("Cформировать общий отчет о студентах",
            CommandFactory.createReportCommand());

    private final String text;
    private final Command command;

    Operation(String text, Command command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public Command getCommand() {
        return command;
    }
}
