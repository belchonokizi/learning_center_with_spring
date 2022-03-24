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
@Sql({"/programs/programs-schema.sql", "/programs/programs-test-data.sql"})
class JDBCProgramRepositoryTest {
    @Autowired
    JDBCProgramRepository programRepository;

    private final Program program1 = new Program(1, "Java", null);
    private final Program program2 = new Program(2, "JavaScript", null);
    private final Program program3 = new Program(3, ".Net", null);

    @Test
    void getAllPrograms() {
        List<Program> programs = programRepository.getAllPrograms();
        assertEquals(2, programs.size());
        assertThat(programs, hasItem(program1));
        assertThat(programs, hasItem(program2));
    }

    @Test
    void addProgram() {
        assertTrue(programRepository.addProgram(program3));
        Program result = programRepository.findProgramById(3);
        assertEquals(program3, result);
    }

    @Test
    void deleteProgram() {
        assertTrue(programRepository.deleteProgram(1));
        assertNull(programRepository.findProgramById(1));
    }

    @Test
    void findProgramById() {
        Program result = programRepository.findProgramById(1);
        assertEquals(program1, result);
    }
}