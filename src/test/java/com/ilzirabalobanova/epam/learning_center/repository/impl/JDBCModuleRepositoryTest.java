package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
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
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/modules/modules-schema.sql", "/modules/modules-test-data.sql"})
class JDBCModuleRepositoryTest {
    @Autowired
    private JDBCModuleRepository moduleRepository;

    private final Module module1 = new Module(1, 1, "first_module_java", 48);
    private final Module module2 = new Module(2, 1, "first_module_java", 24);
    private final Module module3 = new Module(3, 2, "first_module_javascript", 24);

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/modules/find-all-modules-by-program-id.sql"})
    void findAllModulesByProgramId(String path) {
        List<Module> result = moduleRepository.findAllModulesByProgramId(1, path);
        assertThat(result, hasSize(2));
        assertThat(result, hasItem(module1));
        assertThat(result, hasItem(module2));
    }

    @ParameterizedTest
    @CsvSource({"src/test/resources/modules/add-module.sql," +
            "src/test/resources/modules/find-all-modules-by-program-id.sql"})
    void addModule(String path1, String path2) {
        assertTrue(moduleRepository.addModule(module3, path1));
        List<Module> result = moduleRepository.findAllModulesByProgramId(2, path2);
        assertThat(result, hasSize(1));
        assertThat(result, hasItem(module3));
    }

    @ParameterizedTest
    @CsvSource({"src/main/resources/queries/crud/module/delete_module.sql," +
            "src/test/resources/modules/find-all-modules-by-program-id.sql"})
    void deleteModule(String path1, String path2) {
        assertTrue(moduleRepository.deleteModule(1, path1));
        List<Module> result = moduleRepository.findAllModulesByProgramId(1, path2);
        assertThat(result, hasSize(1));
        assertFalse(result.contains(module1));
    }
}