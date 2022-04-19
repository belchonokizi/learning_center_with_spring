package com.ilzirabalobanova.epam.repository.impl;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.repository.IPaymentRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentRepositoryTest {
    @Autowired
    private IPaymentRepository paymentRepository;

    @ParameterizedTest
    @MethodSource("paymentEntitiesMethodSource")
    void savePayment(PaymentEntity paymentEntity) {
        long oldBalance = paymentRepository.getBalanceByStudentId(1).orElseThrow().getAmount();
        assertThrows(Exception.class, () -> {
            paymentRepository.savePayment(paymentEntity);
        });
        long newBalance = paymentRepository.getBalanceByStudentId(1).orElseThrow().getAmount();
        assertEquals(oldBalance, newBalance);
    }

    static PaymentEntity[] paymentEntitiesMethodSource() {
        return new PaymentEntity[]{null, new PaymentEntity(1, 1, -100L, "12-01-2022")};
    }
}