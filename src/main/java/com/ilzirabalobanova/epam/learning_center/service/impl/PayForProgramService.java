package com.ilzirabalobanova.epam.learning_center.service.impl;

import com.ilzirabalobanova.epam.learning_center.gateway.PaymentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class PayForProgramService {
    private final PaymentClient paymentClient;

    public void payForProgram(int studentId, int programId, Long paymentAmount) {
        paymentClient.setPayment(BigInteger.valueOf(studentId), BigInteger.valueOf(programId), paymentAmount);
    }
}
