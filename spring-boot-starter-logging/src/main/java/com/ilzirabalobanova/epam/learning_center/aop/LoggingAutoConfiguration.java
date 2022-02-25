package com.ilzirabalobanova.epam.learning_center.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "logging.loggable")
@EnableConfigurationProperties(LoggingProperties.class)
public class LoggingAutoConfiguration {

    private final LoggingProperties loggingProperties;

    @Autowired
    public LoggingAutoConfiguration(LoggingProperties loggingProperties) {
        this.loggingProperties = loggingProperties;
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
