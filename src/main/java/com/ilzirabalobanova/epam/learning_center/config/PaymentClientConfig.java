package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.gateway.client.PaymentClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PaymentClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.ilzirabalobanova.epam.payments");
        return marshaller;
    }

    @Bean
    public PaymentClient paymentClient(Jaxb2Marshaller marshaller) {
        PaymentClient paymentClient = new PaymentClient();
        paymentClient.setDefaultUri("http://localhost:8080/api/soap/payments");
        paymentClient.setMarshaller(marshaller);
        paymentClient.setUnmarshaller(marshaller);
        return paymentClient;
    }
}
