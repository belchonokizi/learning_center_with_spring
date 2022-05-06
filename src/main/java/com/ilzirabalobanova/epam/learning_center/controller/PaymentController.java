package com.ilzirabalobanova.epam.learning_center.controller;

import com.ilzirabalobanova.epam.learning_center.service.impl.PayForProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PayForProgramService payForProgramService;

    @PostMapping("/{studentId}/{programId}/{paymentAmount}")
    public void payForTheProgram(@PathVariable Integer studentId,
                                 @PathVariable Integer programId,
                                 @PathVariable Long paymentAmount) {
        payForProgramService.payForProgram(studentId, programId, paymentAmount);
    }
}
