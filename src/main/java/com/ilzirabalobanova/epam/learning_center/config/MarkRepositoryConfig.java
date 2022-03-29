package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCMarkRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaMarkRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkRepositoryConfig {

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JPA")
    public JpaMarkRepository jpaMarkRepository() {
        return new JpaMarkRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JDBC")
    public JDBCMarkRepository jdbcMarkRepository() {
        return new JDBCMarkRepository();
    }
}
