//package com.ilzirabalobanova.epam.learning_center.repository;
//
//import com.ilzirabalobanova.epam.learning_center.entity.Program;
//import com.ilzirabalobanova.epam.learning_center.repository.impl.ProgramRepository;
//import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.hasItem;
//import static org.hamcrest.Matchers.hasSize;
//
//public class ProgramRepositoryTest {
//    private IProgramRepository programRepository;
//    private final List<Program> programs = new ArrayList<>();
//    private final Program program1 = new Program(1, "Java", List.of());
//    private final Program program2 = new Program(2, "SQL", List.of());
//
//    @Mock
//    private YamlParser parser;
//
//    @BeforeEach
//    void setUp() {
//        addProgramToList();
//        MockitoAnnotations.openMocks(this);
//        Mockito.when(parser.getPrograms(Mockito.anyString())).thenReturn(programs);
//        this.programRepository = new ProgramRepository(parser);
//    }
//
//    @AfterEach
//    void clearList() {
//        programs.clear();
//    }
//
//    @Test
//    void getAllPrograms() {
//        List<Program> programList = programRepository.getAllPrograms();
//        assertThat(programList, hasSize(2));
//        assertThat(programList, hasItem(program1));
//        assertThat(programList, hasItem(program2));
//    }
//
//    private void addProgramToList() {
//        programs.add(program1);
//        programs.add(program2);
//    }
//}