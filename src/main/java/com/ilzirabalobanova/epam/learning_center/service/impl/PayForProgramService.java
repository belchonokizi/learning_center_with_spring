package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.learning_center.gateway.client.PaymentClient;
import com.ilzirabalobanova.epam.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PayForProgramService {
    private final PaymentClient paymentClient;
    private final IPaymentService paymentService;

    public void payForProgram(int studentId, int programId, Long paymentAmount) {
        paymentClient.setPayment(BigInteger.valueOf(studentId), BigInteger.valueOf(programId), paymentAmount);
        PaymentEntity paymentEntity = new PaymentEntity(studentId, programId, paymentAmount, LocalDate.now().toString());
        paymentService.saveNewPayment(paymentEntity);
    }
}
