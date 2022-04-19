package com.ilzirabalobanova.epam.repository;

import com.ilzirabalobanova.epam.entity.BalanceEntity;
import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.exception.NotEnoughAmountForPaymentException;

import java.util.List;
import java.util.Optional;

public interface IPaymentRepository {
    List<PaymentEntity> getPaymentByStudentId(Integer studentId);

    Optional<PaymentEntity> savePayment(PaymentEntity paymentEntity) throws NotEnoughAmountForPaymentException;

    Optional<BalanceEntity> getBalanceByStudentId(Integer studentId);
}
