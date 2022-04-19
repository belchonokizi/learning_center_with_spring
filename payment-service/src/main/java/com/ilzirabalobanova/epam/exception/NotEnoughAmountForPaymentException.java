package com.ilzirabalobanova.epam.exception;

public class NotEnoughAmountForPaymentException extends RuntimeException{

    public NotEnoughAmountForPaymentException(String message) {
        super(message);
    }
}
