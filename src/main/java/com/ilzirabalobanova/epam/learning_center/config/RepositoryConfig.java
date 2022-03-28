package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCStudentRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaStudentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JpaStudentRepository")
    public JpaStudentRepository jpaStudentRepository() {
        return new JpaStudentRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JDBCStudentRepository")
    public JDBCStudentRepository jdbcStudentRepository() {
        return new JDBCStudentRepository();
    }
}
