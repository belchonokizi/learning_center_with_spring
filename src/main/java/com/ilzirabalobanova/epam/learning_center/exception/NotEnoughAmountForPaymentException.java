package com.ilzirabalobanova.epam.learning_center.exception;

public class NotEnoughAmountForPaymentException extends RuntimeException{

    public NotEnoughAmountForPaymentException(String message) {
        super(message);
    }
}
