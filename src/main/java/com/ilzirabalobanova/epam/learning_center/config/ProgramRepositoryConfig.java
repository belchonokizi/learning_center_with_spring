package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.entity.Program;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCModuleRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCProgramRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaProgramRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories(
        repositoryBaseClass = JpaProgramRepository.class)
public class ProgramRepositoryConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JPA")
    public JpaProgramRepository jpaProgramRepository() {
        return new JpaProgramRepository(Program.class, entityManager);
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JDBC")
    public JDBCProgramRepository jdbcProgramRepository() {
        return new JDBCProgramRepository();
    }
}
