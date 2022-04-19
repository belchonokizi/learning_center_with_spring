package com.ilzirabalobanova.epam.service;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.Balance;
import com.ilzirabalobanova.epam.payments.Payment;

import java.util.List;

public interface IPaymentService {
    Payment saveNewPayment(PaymentEntity paymentEntity);
    List<Payment> getPaymentByStudentId(Integer studentId);
    Balance getBalanceByStudentId(Integer studentId);
}
