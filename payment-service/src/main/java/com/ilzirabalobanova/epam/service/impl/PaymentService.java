package com.ilzirabalobanova.epam.service.impl;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.Payment;
import com.ilzirabalobanova.epam.repository.IPaymentRepository;
import com.ilzirabalobanova.epam.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.function.Function;

@Service
public class PaymentService implements IPaymentService {
    private static final Function<PaymentEntity, Payment> FUNCTION_ENTITY_TO_SOAP = paymentEntity -> {
        Payment payment = new Payment();
        payment.setId(BigInteger.valueOf(paymentEntity.getId()));
        payment.setStudentId(BigInteger.valueOf(paymentEntity.getStudentId()));
        payment.setProgramId(BigInteger.valueOf(paymentEntity.getProgramId()));
        payment.setPaymentAmount(paymentEntity.getPaymentAmount());
        payment.setDateOfPayment(paymentEntity.getDateOfPayment());
        return payment;
    };

    private final IPaymentRepository paymentRepository;

    @Autowired
    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment saveNewPayment(PaymentEntity paymentEntity) {
        return paymentRepository.savePayment(paymentEntity).map(FUNCTION_ENTITY_TO_SOAP).orElseThrow();
    }

    @Override
    public Payment getPaymentByStudentId(Integer studentId) {
        return null;
    }
}
