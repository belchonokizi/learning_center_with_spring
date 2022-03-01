package com.ilzirabalobanova.epam.learning_center;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.command.CommandExecutor;
import com.ilzirabalobanova.epam.learning_center.config.LearningCenterConfig;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.operation.Operation;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(LearningCenterConfig.class);
        ConsoleHelper helper = context.getBean("consoleHelper", ConsoleHelper.class);
        CommandExecutor executor = context.getBean("commandExecutor", CommandExecutor.class);
        Operation operation;
        do {
            try {
                operation = helper.askOperation();
                String commandName = operation.getCommandName();
                for (Map.Entry<String, Command> pair : executor.getCommandMap().entrySet()) {
                    if (pair.getKey().equals(commandName)) {
                        pair.getValue().execute();
                    }
                }

            } catch (IllegalInitialDataException e) {
                logger.error("Ошибка получения данных {}", e.getMessage());
            }
            System.out.println("\nЕсли хотите продолжить, наберите 'y'");
        } while (helper.readString().equalsIgnoreCase("y"));
    }
}