package com.ilzirabalobanova.epam.service.impl;

import com.ilzirabalobanova.epam.entity.BalanceEntity;
import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.Balance;
import com.ilzirabalobanova.epam.payments.Payment;
import com.ilzirabalobanova.epam.repository.IPaymentRepository;
import com.ilzirabalobanova.epam.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class PaymentService implements IPaymentService {
    private static final Function<PaymentEntity, Payment> FUNCTION_PAYMENT_ENTITY_TO_SOAP = paymentEntity -> {
        Payment payment = new Payment();
        payment.setId(BigInteger.valueOf(paymentEntity.getId()));
        payment.setStudentId(BigInteger.valueOf(paymentEntity.getStudentId()));
        payment.setProgramId(BigInteger.valueOf(paymentEntity.getProgramId()));
        payment.setPaymentAmount(paymentEntity.getPaymentAmount());
        payment.setDateOfPayment(paymentEntity.getDateOfPayment());
        return payment;
    };

    private static final Function<BalanceEntity, Balance> FUNCTION_BALANCE_ENTITY_TO_SOAP = balanceEntity -> {
        Balance balance = new Balance();
        balance.setId(BigInteger.valueOf(balanceEntity.getId()));
        balance.setStudentId(BigInteger.valueOf(balanceEntity.getStudentId()));
        balance.setAmount(balanceEntity.getAmount());
        return balance;
    };

    private final IPaymentRepository paymentRepository;

    @Autowired
    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment saveNewPayment(PaymentEntity paymentEntity) {
        return paymentRepository.savePayment(paymentEntity).map(FUNCTION_PAYMENT_ENTITY_TO_SOAP).orElseThrow();
    }

    @Override
    public List<Payment> getPaymentByStudentId(Integer studentId) {
        List<PaymentEntity> payments = paymentRepository.getPaymentByStudentId(studentId);
        if (payments.isEmpty()) {
            log.error("Payments are not found");
            return Collections.emptyList();
        }
        return payments.stream().map(FUNCTION_PAYMENT_ENTITY_TO_SOAP).collect(Collectors.toList());
    }

    @Override
    public Balance getBalanceByStudentId(Integer studentId) {
        return paymentRepository.getBalanceByStudentId(studentId).map(FUNCTION_BALANCE_ENTITY_TO_SOAP).orElseThrow();
    }
}
