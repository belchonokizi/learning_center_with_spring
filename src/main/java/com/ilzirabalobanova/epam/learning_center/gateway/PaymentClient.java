package com.ilzirabalobanova.epam.learning_center.gateway;

import com.ilzirabalobanova.epam.endpoint.PaymentEndpoint;
import com.ilzirabalobanova.epam.payments.ObjectFactory;
import com.ilzirabalobanova.epam.payments.SetPaymentRequest;
import com.ilzirabalobanova.epam.payments.SetPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;
@Component
@RequiredArgsConstructor
public class PaymentClient extends WebServiceGatewaySupport {
    private static final String SOAP_URL = "http://localhost:8080/api/soap/payments";
    private final ObjectFactory objectFactory;
    private final PaymentEndpoint paymentEndpoint;

    public SetPaymentResponse setPayment(BigInteger studentId, BigInteger programId, Long paymentAmount) {
        SetPaymentRequest request = objectFactory.createSetPaymentRequest();
        request.setStudentId(studentId);
        request.setProgramId(programId);
        request.setPaymentAmount(paymentAmount);
        return paymentEndpoint.setNewPayment(request);
    }
}
