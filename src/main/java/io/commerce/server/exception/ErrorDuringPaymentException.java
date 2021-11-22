package io.commerce.server.exception;

public class ErrorDuringPaymentException extends RuntimeException{

    public ErrorDuringPaymentException(final String message) {
        super("Error During payment : " +message);
    }

}
