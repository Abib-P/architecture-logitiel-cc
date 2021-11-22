package io.commerce.server.exception;

public class PaymentNotValidException extends RuntimeException{
    private final String message;

    public PaymentNotValidException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
