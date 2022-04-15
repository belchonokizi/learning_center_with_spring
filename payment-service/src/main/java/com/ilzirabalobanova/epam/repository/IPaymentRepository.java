package com.ilzirabalobanova.epam.repository;

import com.ilzirabalobanova.epam.entity.PaymentEntity;

import java.util.Optional;

public interface IPaymentRepository {
    Optional<PaymentEntity> getPaymentByStudentId(Integer studentId);
    Optional<PaymentEntity> savePayment(PaymentEntity paymentEntity);
}
