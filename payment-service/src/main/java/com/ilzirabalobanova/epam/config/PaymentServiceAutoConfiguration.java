package com.ilzirabalobanova.epam.config;

import com.ilzirabalobanova.epam.payments.ObjectFactory;
import com.ilzirabalobanova.epam.repository.impl.PaymentRepository;
import com.ilzirabalobanova.epam.service.impl.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@RequiredArgsConstructor
public class PaymentServiceAutoConfiguration {
    @PersistenceContext
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
}
