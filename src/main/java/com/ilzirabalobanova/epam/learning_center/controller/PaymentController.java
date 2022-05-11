package com.ilzirabalobanova.epam.learning_center.controller;

import com.ilzirabalobanova.epam.entity.PaymentEntity;
import com.ilzirabalobanova.epam.learning_center.service.impl.PayForProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PayForProgramService payForProgramService;

    @PostMapping()
    public void payForTheProgram(@RequestBody PaymentEntity paymentEntity) {
        payForProgramService.payForProgram(paymentEntity.getStudentId(), paymentEntity.getProgramId(), paymentEntity.getPaymentAmount());
    }
}
