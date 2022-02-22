package com.ilzirabalobanova.epam.learning_center.parser;

import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

class StudentFileParserTest {
    private final StudentFileParser parser = new StudentFileParser();
    private final Student student1 = new Student(1, "Alisa", "Grey", 1,
            Map.of("firstModuleJava", 75, "secondModuleJava", 80));
    private final Student student2 = new Student(3, "Bob", "Singer", 3,
            Map.of("firstModuleNote", 60, "secondModuleNote", 80, "thirdModuleNote", 80, "fourthModuleNote", 40));

    @ParameterizedTest
    @ValueSource(strings = {"src\\test\\resources\\students.json"})
    void getStudents(String path) {
        List<Student> result = parser.getStudents(path);
        assertThat(result, hasSize(2));
        assertThat(result, hasItem(student1));
        assertThat(result, hasItem(student2));
    }
}