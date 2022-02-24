package com.ilzirabalobanova.epam.learning_center.config;

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
}
