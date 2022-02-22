package com.ilzirabalobanova.epam.learning_center.util.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class StudentFileParser {
    private static final Logger logger = LoggerFactory.getLogger(StudentFileParser.class);

    private final ObjectMapper mapper = new ObjectMapper();

    public List<Student> getStudents(String path) {
        List<Student> students = null;
        try {
            students = mapper.readValue(new File(path),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            logger.error("Ошибка чтения файла students.json {}", e.getMessage());
        }
        return students;
    }
}
