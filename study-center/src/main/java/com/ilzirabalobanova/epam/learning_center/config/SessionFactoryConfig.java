package com.ilzirabalobanova.epam.learning_center.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SessionFactoryConfig {
    private final DataSource dataSource;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.ilzirabalobanova.epam.entity", "com.ilzirabalobanova.epam.learning_center.entity");
        return sessionFactory;
    }
}
