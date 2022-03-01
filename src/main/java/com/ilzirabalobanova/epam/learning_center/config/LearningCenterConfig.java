package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.command.impl.*;
import com.ilzirabalobanova.epam.learning_center.util.parser.StudentFileParser;
import com.ilzirabalobanova.epam.learning_center.util.parser.YamlParser;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.ilzirabalobanova.epam.learning_center")
@EnableAspectJAutoProxy
public class LearningCenterConfig {

    @Bean
    public YamlParser yamlParser() {
        return new YamlParser();
    }

    @Bean
    public StudentFileParser studentFileParser() {
        return new StudentFileParser();
    }

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
}
