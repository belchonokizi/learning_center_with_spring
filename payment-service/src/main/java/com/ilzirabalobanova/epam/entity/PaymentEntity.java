package com.ilzirabalobanova.epam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "program_id")
    private Integer programId;

    @Column(name = "payment_amount")
    private Long paymentAmount;

    @Column(name = "date_of_payment")
    private String dateOfPayment;

    public PaymentEntity(Integer studentId, Integer programId, Long paymentAmount, String dateOfPayment) {
        this.studentId = studentId;
        this.programId = programId;
        this.paymentAmount = paymentAmount;
        this.dateOfPayment = dateOfPayment;
    }
}
