package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCMarkRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCModuleRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaMarkRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaModuleRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkRepositoryConfig {

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "mark-repository", havingValue = "JpaMarkRepository")
    public JpaMarkRepository jpaMarkRepository() {
        return new JpaMarkRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "mark-repository", havingValue = "JDBCMarkRepository")
    public JDBCMarkRepository jdbcMarkRepository() {
        return new JDBCMarkRepository();
    }
}
