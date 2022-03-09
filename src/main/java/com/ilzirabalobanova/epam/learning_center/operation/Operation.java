package com.ilzirabalobanova.epam.learning_center.operation;

public enum Operation {
    ADD("Добавить студента", "addCommand"),
    REMOVE("Удалить студента",
            "removeCommand"),
    PUT_MARK("Поставить оценку за тест по теме",
            "putMarkCommand"),
    COUNT_DAYS("Рассчитать количество дней до завершения программы",
            "countDaysCommand"),
    GET_SCORE("Рассчитать и вывести отчет об успеваемости",
            "getScoreCommand"),
    NOTIFY_ABOUT_EXCLUSION("Рассчитать возможность отчисления студента",
            "notifyCommand"),
    SHOW_ALL_STUDENTS("Просмотреть список всех студентов",
            "showAllStudentCommand"),
    FILTER("Фильтровать список студентов по условию \"Есть вероятность, что не будет отчислен\"",
            "filterCommand"),
    CREATE_REPORT("Cформировать общий отчет о студентах",
            "createReportCommand");

    private final String text;
    private final String commandName;

    Operation(String text, String commandName) {
        this.text = text;
        this.commandName = commandName;
    }

    public String getText() {
        return text;
    }

    public String getCommandName() {
        return commandName;
    }
}
