package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCModuleRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCStudentRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaModuleRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaStudentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleRepositoryConfig {

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "module-repository", havingValue = "JpaModuleRepository")
    public JpaModuleRepository jpaModuleRepository() {
        return new JpaModuleRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "module-repository", havingValue = "JDBCModuleRepository")
    public JDBCModuleRepository jdbcModuleRepository() {
        return new JDBCModuleRepository();
    }
}
