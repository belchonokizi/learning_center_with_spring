package com.ilzirabalobanova.epam.endpoint;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.Payment;
import com.ilzirabalobanova.epam.payments.SetPaymentRequest;
import com.ilzirabalobanova.epam.payments.SetPaymentResponse;
import com.ilzirabalobanova.epam.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;

@Endpoint
public class PaymentEndpoint {
    private static final String NAMESPACE_URI = "http://www.ilzirabalobanova.com/spring/ws/payments";
    private static final String LOCAL_PART_SET_PAYMENT_REQUEST = "setPaymentRequest";

    private final IPaymentService paymentService;

    @Autowired
    public PaymentEndpoint(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_SET_PAYMENT_REQUEST)
    @ResponsePayload
    public SetPaymentResponse setNewPayment(@RequestPayload SetPaymentRequest request) {
        PaymentEntity paymentEntity= new PaymentEntity(request.getStudentId().intValue(), request.getProgramId().intValue(),
                request.getPaymentAmount(), LocalDate.now().toString());
        SetPaymentResponse response = new SetPaymentResponse();
        Payment payment = paymentService.saveNewPayment(paymentEntity);
        response.setPayment(payment);
        return response;
    }
}
