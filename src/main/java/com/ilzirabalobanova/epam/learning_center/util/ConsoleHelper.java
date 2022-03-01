package com.ilzirabalobanova.epam.learning_center.util;

import com.ilzirabalobanova.epam.learning_center.operation.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ConsoleHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleHelper.class);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public String readString() {
        String text = null;
        try {
            text = READER.readLine();
        } catch (IOException e) {
            logger.error("Ошибка ввода данных");
        }
        return text;
    }

    public int readInt() {
        String text = readString();
        return Integer.parseInt(text.trim());
    }

    public int askStudentId() {
        System.out.println("Введите id студента");
        return readInt();
    }

    public Operation askOperation() {
        System.out.println("Выберите операцию:");
        for (Operation operation : Operation.values()) {
            System.out.printf("\t%d - %s%n", operation.ordinal(), operation.getText());
        }
        return Operation.values()[readInt()];
    }
}

