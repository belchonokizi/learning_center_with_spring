package com.ilzirabalobanova.epam.endpoint;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.*;
import com.ilzirabalobanova.epam.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
@Endpoint
@Slf4j
@RequiredArgsConstructor
public class PaymentEndpoint {
    private static final String NAMESPACE_URI = "http://www.ilzirabalobanova.com/spring/ws/payments";
    private static final String LOCAL_PART_SET_PAYMENT_REQUEST = "setPaymentRequest";
    private static final String LOCAL_PART_GET_PAYMENT_BY_STUDENT_ID_REQUEST = "getPaymentByStudentIdRequest";
    private final IPaymentService paymentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_SET_PAYMENT_REQUEST)
    @ResponsePayload
    public SetPaymentResponse setNewPayment(@RequestPayload SetPaymentRequest request) {
        log.info("Hi");
        PaymentEntity paymentEntity = new PaymentEntity(request.getStudentId().intValue(), request.getProgramId().intValue(),
                request.getPaymentAmount(), LocalDate.now().toString());
        SetPaymentResponse response = new SetPaymentResponse();
        Payment payment = paymentService.saveNewPayment(paymentEntity);
        response.setPayment(payment);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART_GET_PAYMENT_BY_STUDENT_ID_REQUEST)
    @ResponsePayload
    public GetPaymentByStudentIdResponse getPaymentById(@RequestPayload GetPaymentByStudentIdRequest request) {
        GetPaymentByStudentIdResponse response = new GetPaymentByStudentIdResponse();
        PaymentList paymentList = new PaymentList();
        int studentId = request.getStudentId().intValue();
        paymentList.getPayment().addAll(paymentService.getPaymentByStudentId(studentId));
        response.setPaymentList(paymentList);
        response.setBalance(paymentService.getBalanceByStudentId(studentId));
        return response;
    }
}
