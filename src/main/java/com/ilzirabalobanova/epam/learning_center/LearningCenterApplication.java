package com.ilzirabalobanova.epam.learning_center;

import com.ilzirabalobanova.epam.learning_center.command.Command;
import com.ilzirabalobanova.epam.learning_center.command.CommandExecutor;
import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.operation.Operation;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
public class LearningCenterApplication {
    private static final Logger logger = LoggerFactory.getLogger(LearningCenterApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearningCenterApplication.class, args);

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
