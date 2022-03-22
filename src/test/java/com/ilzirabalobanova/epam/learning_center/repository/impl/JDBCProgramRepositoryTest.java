package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/programs-schema.sql", "/programs-test-data.sql"})
class JDBCProgramRepositoryTest {
    @Autowired
    JDBCProgramRepository programRepository;

    private final Program program1 = new Program(1, "Java", null);
    private final Program program2 = new Program(2, "JavaScript", null);
    private final Program program3 = new Program(3, ".Net", null);

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/programs/find-all-programs.sql"})
    void getAllPrograms(String path) {
        List<Program> programs = programRepository.getAllPrograms(path);
        assertEquals(2, programs.size());
        assertThat(programs, hasItem(program1));
        assertThat(programs, hasItem(program2));
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/programs/add-program.sql," +
            "src/test/resources/programs/find-program-by-id.sql"})
    void addProgram(String path1, String path2) {
        assertTrue(programRepository.addProgram(program3, path1));
        Program result = programRepository.findProgramById(3, path2);
        assertEquals(program3, result);
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/programs/delete-program.sql," +
            "src/test/resources/programs/find-program-by-id.sql"})
    void deleteProgram(String path1, String path2) {
        assertTrue(programRepository.deleteProgram(1, path1));
        assertNull(programRepository.findProgramById(1, path2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/programs/find-program-by-id.sql"})
    void findProgramById(String path) {
        Program result = programRepository.findProgramById(1, path);
        assertEquals(program1, result);
    }
}