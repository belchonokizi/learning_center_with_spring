package com.ilzirabalobanova.epam;

import com.ilzirabalobanova.epam.repository.impl.PaymentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PaymentServiceApplication.class, args);
        PaymentRepository paymentRepository = context.getBean(PaymentRepository.class);
    }

}
