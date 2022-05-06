package com.ilzirabalobanova.epam.config;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.ObjectFactory;
import com.ilzirabalobanova.epam.repository.impl.PaymentRepository;
import com.ilzirabalobanova.epam.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class PaymentServiceAutoConfiguration {
    @Autowired
    private EntityManager entityManager;

    @Bean
    public PaymentRepository paymentRepository() {
        return new PaymentRepository(entityManager);
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(paymentRepository());
    }

    @Bean
    public PaymentEntity paymentEntity() {
        return new PaymentEntity();
    }
}
