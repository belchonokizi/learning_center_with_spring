package com.ilzirabalobanova.epam.repository.impl;

import com.ilzirabalobanova.epam.entity.BalanceEntity;
import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.exception.NotEnoughAmountForPaymentException;
import com.ilzirabalobanova.epam.repository.IPaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
public class PaymentRepository implements IPaymentRepository {
    private final EntityManager entityManager;

    @Autowired
    public PaymentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PaymentEntity> getPaymentByStudentId(Integer studentId) {
        Session session = entityManager.unwrap(Session.class);
        return (List<PaymentEntity>) session.createQuery("from PaymentEntity where studentId = " + studentId).getResultList();
    }

    @Override
    @Transactional
    public Optional<PaymentEntity> savePayment(PaymentEntity paymentEntity) throws NotEnoughAmountForPaymentException {
        Long paymentAmount = paymentEntity.getPaymentAmount();
        if (paymentAmount > 0) {
            entityManager.unwrap(Session.class).save(Objects.requireNonNull(paymentEntity));
        } else {
            throw new IllegalArgumentException("Некорректное значение суммы платежа");
        }
        updateBalance(paymentEntity.getStudentId(), paymentAmount);
        return Optional.of(paymentEntity);
    }

    private void updateBalance(Integer studentId, Long amount) {
        BalanceEntity currentBalance = getBalanceByStudentId(studentId).orElseThrow();
        if (currentBalance.getAmount() < amount) {
            throw new NotEnoughAmountForPaymentException("Недостаточно средств на балансе для совершения платежа");
        } else {
            long newAmount = currentBalance.getAmount() - amount;
            entityManager.createNativeQuery("update balances set amount = ? where student_id = ?")
                    .setParameter(1, newAmount).setParameter(2, studentId).executeUpdate();
        }
    }

    @Override
    public Optional<BalanceEntity> getBalanceByStudentId(Integer studentId) {
        BalanceEntity balanceEntity = (BalanceEntity) entityManager.createQuery("select b from BalanceEntity b " +
                "where b.studentId = :studentId").setParameter("studentId", studentId).getSingleResult();
        return Optional.of(balanceEntity);
    }
}
