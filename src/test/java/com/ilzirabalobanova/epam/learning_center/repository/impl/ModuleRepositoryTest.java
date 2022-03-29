package com.ilzirabalobanova.epam.learning_center.repository.impl;

import com.ilzirabalobanova.epam.learning_center.entity.Module;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCModuleRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaModuleRepository;
import org.junit.jupiter.api.Test;
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
class ModuleRepositoryTest {
    @Autowired
    private JDBCModuleRepository moduleRepository;

    private final Module module1 = new Module(1, 1, "first_module_java", 48);
    private final Module module2 = new Module(2, 1, "first_module_java", 24);
    private final Module module3 = new Module(3, 2, "first_module_javascript", 24);

    @Test
    void findAllModulesByProgramId() {
        List<Module> result = moduleRepository.findAllModulesByProgramId(1);
        assertThat(result, hasSize(2));
        assertThat(result, hasItem(module1));
        assertThat(result, hasItem(module2));
    }

    @Test
    void addModule() {
        assertTrue(moduleRepository.addModule(module3));
        List<Module> result = moduleRepository.findAllModulesByProgramId(2);
        assertThat(result, hasSize(1));
        assertThat(result, hasItem(module3));
    }

    @Test
    void deleteModule() {
        assertTrue(moduleRepository.deleteModule(1));
        List<Module> result = moduleRepository.findAllModulesByProgramId(1);
        assertThat(result, hasSize(1));
        assertFalse(result.contains(module1));
    }
}