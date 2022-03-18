package com.ilzirabalobanova.epam.learning_center.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class SqlQueriesReader {
    private static Logger logger = LoggerFactory.getLogger(SqlQueriesReader.class);

    public String readSqlQueries(String path) {
        StringBuilder sb = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(sb::append);

        } catch (IOException ex) {
            logger.error("Ошибка чтения файла {}", path);
        }
        return sb.toString();
    }
}
