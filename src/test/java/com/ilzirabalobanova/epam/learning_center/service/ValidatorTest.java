package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {
    @Mock
    private IProgramService programService;

    private Validator validator;
    private final List<Program> programs = new ArrayList<>();
    private final Program program1 = new Program(1, "Java", List.of());
    private final Program program2 = new Program(2, "SQL", List.of());

    @BeforeEach
    public void setUp() {
        addProgramToList();
        MockitoAnnotations.openMocks(this);
        Mockito.when(programService.getAllPrograms()).thenReturn(programs);
        this.validator = new Validator(programService);
    }

    @Test
    void isNameNonValid() {
        String empty = "";
        boolean result1 = validator.isNameNonValid(empty);
        String digits = "123";
        boolean result2 = validator.isNameNonValid(digits);
        String punct = "...---?";
        boolean result3 = validator.isNameNonValid(punct);
        String digitsAndPunct = "1---34...<345";
        boolean result4 = validator.isNameNonValid(digitsAndPunct);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);
    }

    @Test
    void isIntValid() {
        boolean result1 = validator.isIntValid(1);
        boolean result2 = validator.isIntValid(2);
        boolean result3 = validator.isIntValid(3);
        boolean result4 = validator.isIntValid(0);

        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

    private void addProgramToList() {
        programs.add(program1);
        programs.add(program2);
    }
}