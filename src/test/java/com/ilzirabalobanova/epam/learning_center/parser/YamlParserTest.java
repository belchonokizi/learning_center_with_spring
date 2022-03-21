//package com.ilzirabalobanova.epam.learning_center.parser;
//
//import com.ilzirabalobanova.epam.learning_center.entity.Program;
//import com.ilzirabalobanova.epam.learning_center.entity.Module;
//import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasItem;
//import static org.hamcrest.Matchers.hasSize;
//
//class YamlParserTest {
//    private final YamlParser parser = new YamlParser();
//    private final Program program1 = new Program(1, "Java", List.of(new Module(1, 1, "firstModule", 72),
//            new Module(2, 1, "secondModule", 48), new Module(3, 1, "thirdModule", 32)));
//    private final Program program2 = new Program(2, "JavaScript", List.of(new Module(1, 2, "firstModule", 32),
//            new Module(2, 2, "secondModule", 56), new Module(3, 2, "thirdModule", 32)));
//
//    @ParameterizedTest
//    @ValueSource(strings = {"src\\test\\resources\\program.yaml"})
//    void getPrograms(String path) {
//        List<Program> programs = parser.getPrograms(path);
//        assertThat(programs, hasSize(2));
//        assertThat(programs, hasItem(program1));
//        assertThat(programs, hasItem(program2));
//    }
//}