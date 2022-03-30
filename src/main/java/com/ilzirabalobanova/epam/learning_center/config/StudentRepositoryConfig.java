package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCStudentRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaStudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class StudentRepositoryConfig {

    @Bean
    @Profile("prod")
    public JpaStudentRepository jpaStudentRepository() {
        return new JpaStudentRepository();
    }

    @Bean
    @Profile("dev")
    public JDBCStudentRepository jdbcStudentRepository() {
        return new JDBCStudentRepository();
    }
}
