package com.ilzirabalobanova.epam.repository.impl;

import com.ilzirabalobanova.epam.entity.BalanceEntity;
import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.repository.IPaymentRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class PaymentRepository implements IPaymentRepository {
    private final EntityManager entityManager;

    @Autowired
    public PaymentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<PaymentEntity> getPaymentByStudentId(Integer studentId) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<PaymentEntity> savePayment(PaymentEntity paymentEntity) {
        entityManager.unwrap(Session.class).save(paymentEntity);
        reduceBalance(paymentEntity.getStudentId(), paymentEntity.getPaymentAmount());
        return Optional.of(paymentEntity);
    }

    private void reduceBalance(Integer studentId, Long amount) {
        BalanceEntity currentBalance = getBalanceByStudentId(studentId);
        long newAmount = currentBalance.getAmount() - amount;
        entityManager.createNativeQuery("update balances set amount = ? where student_id = ?")
                .setParameter(1, newAmount).setParameter(2, studentId).executeUpdate();
    }

    private BalanceEntity getBalanceByStudentId(Integer studentId) {
        return (BalanceEntity) entityManager.createQuery("select b from BalanceEntity b " +
                "where b.studentId = :studentId").setParameter("studentId", studentId).getSingleResult();
    }
}
