package com.ilzirabalobanova.epam.learning_center.service;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.entity.Student;
import com.ilzirabalobanova.epam.learning_center.repository.IProgramRepository;
import com.ilzirabalobanova.epam.learning_center.service.impl.ProgramService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramServiceTest {

    private IProgramService programService;

    @Mock
    private IProgramRepository programRepository;

    private final Student student = new Student(1, "Алиса", "Селезнёва", 1,
            Map.of("firstModuleJava", 70, "secondModuleJava", 80, "thirdModuleJava", 90));
    private final List<Program> programs = new ArrayList<>();
    private final Program program1 = new Program(1, "Java", List.of());
    private final Program program2 = new Program(2, "SQL", List.of());

    @BeforeEach
    public void setUp() {
        addProgramToList();
        MockitoAnnotations.openMocks(this);
        this.programService = new ProgramService(programRepository);
    }

    @AfterEach
    public void clearList() {
        programs.clear();
    }

    @Test
    void findProgramById() {
        Mockito.when(programRepository.getAllPrograms()).thenReturn(programs);
        Program resultProgram = programService.findProgramById(1);
        assertEquals(program1, resultProgram);
    }

    @Test
    void getAllPrograms() {
        Mockito.when(programRepository.getAllPrograms()).thenReturn(programs);
        List<Program> result = programService.getAllPrograms();
        assertEquals(programs, result);
    }

    @Test
    void getAvgGrade() {
        double avgGrade = programService.getAvgGrade(student);
        assertEquals(80, avgGrade);
    }

    private void addProgramToList() {
        programs.add(program1);
        programs.add(program2);
    }
}