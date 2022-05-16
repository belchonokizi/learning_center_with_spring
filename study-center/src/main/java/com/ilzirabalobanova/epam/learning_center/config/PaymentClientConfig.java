package com.ilzirabalobanova.epam.learning_center.config;

import com.ilzirabalobanova.epam.learning_center.gateway.PaymentClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PaymentClientConfig {

    @Value("${soap.payment-url}")
    String paymentUrl;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.ilzirabalobanova.epam.payments");
        return marshaller;
    }

    @Bean
    public PaymentClient paymentClient(Jaxb2Marshaller marshaller) {
        PaymentClient client = new PaymentClient();
        client.setDefaultUri(paymentUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
