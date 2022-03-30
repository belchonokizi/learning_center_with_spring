package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.entity.Teacher;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jdbc.JDBCTeacherRepository;
import com.ilzirabalobanova.epam.learning_center.repository.impl.jpa.JpaTeacherRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories(
        repositoryBaseClass = JpaTeacherRepository.class)
public class TeacherRepositoryConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JPA")
    public JpaTeacherRepository jpaTeacherRepository() {
        return new JpaTeacherRepository(Teacher.class, entityManager);
    }

    @Bean
    @ConditionalOnProperty(prefix = "resources", name = "repository", havingValue = "JDBC")
    public JDBCTeacherRepository jdbcTeacherRepository() {
        return new JDBCTeacherRepository();
    }
}
