package com.ilzirabalobanova.epam.service;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.payments.Payment;

public interface IPaymentService {
    Payment saveNewPayment(PaymentEntity paymentEntity);
    Payment getPaymentByStudentId(Integer studentId);
}
