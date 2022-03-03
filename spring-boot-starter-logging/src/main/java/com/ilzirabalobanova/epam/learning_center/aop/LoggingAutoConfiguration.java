package com.ilzirabalobanova.epam.learning_center.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "logging", name = "enable")
public class LoggingAutoConfiguration {

    @Bean
    public LearningCenterLoggingAspect learningCenterLoggingAspect() {
        return new LearningCenterLoggingAspect();
    }

    @Bean
    public LoggingProperties loggingProperties() {
        return new LoggingProperties();
    }

    @Bean
    public CustomPointcut customPointcut() {
        return new CustomPointcut(loggingProperties());
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        return new DefaultPointcutAdvisor(customPointcut(), learningCenterLoggingAspect());
    }
}
