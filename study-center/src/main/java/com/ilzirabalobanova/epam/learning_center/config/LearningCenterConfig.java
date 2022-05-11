package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.command.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.support.GeneratedKeyHolder;

@Configuration
@ComponentScan("com.ilzirabalobanova.epam.learning_center")
@EnableAspectJAutoProxy
public class LearningCenterConfig {

    @Bean
    public ShowAllStudentCommand showAllStudentCommand() {
        return new ShowAllStudentCommand();
    }

    @Bean
    public AddCommand addCommand() {
        return new AddCommand();
    }

    @Bean
    public CountDaysCommand countDaysCommand() {
        return new CountDaysCommand();
    }

    @Bean
    public CreateReportCommand createReportCommand() {
        return new CreateReportCommand();
    }

    @Bean
    public FilterCommand filterCommand() {
        return new FilterCommand();
    }

    @Bean
    public GetScoreCommand getScoreCommand() {
        return new GetScoreCommand();
    }

    @Bean
    public NotifyCommand notifyCommand() {
        return new NotifyCommand();
    }

    @Bean
    public PutMarkCommand putMarkCommand() {
        return new PutMarkCommand();
    }

    @Bean
    public RemoveCommand removeCommand() {
        return new RemoveCommand();
    }

    @Bean
    public GeneratedKeyHolder createBeanKeyHolder() {
        return new GeneratedKeyHolder();
    }
}
