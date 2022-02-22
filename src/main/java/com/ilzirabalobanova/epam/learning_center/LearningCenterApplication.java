package com.ilzirabalobanova.epam.learning_center;

import com.ilzirabalobanova.epam.learning_center.exception.IllegalInitialDataException;
import com.ilzirabalobanova.epam.learning_center.operation.Operation;
import com.ilzirabalobanova.epam.learning_center.util.ConsoleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningCenterApplication {
    private static final Logger logger = LoggerFactory.getLogger(LearningCenterApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsoleHelper helper = context.getBean("consoleHelper", ConsoleHelper.class);
        Operation operation;
        do {
            try {
                operation = helper.askOperation();
                operation.getCommand().execute();

            } catch (IllegalInitialDataException e) {
                logger.error("Ошибка получения данных {}", e.getMessage());
            }
            System.out.println("\nЕсли хотите продолжить, наберите 'y'");
        } while (helper.readString().equalsIgnoreCase("y"));
    }
}
