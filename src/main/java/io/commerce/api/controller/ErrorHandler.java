package io.commerce.api.controller;

import io.commerce.api.dto.ErrorMessage;
import io.commerce.server.exception.EmailAlreadyTakenException;
import io.commerce.server.exception.ErrorDuringPaymentException;
import io.commerce.server.exception.MemberNotFoundException;
import io.commerce.server.exception.PaymentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = {MemberNotFoundException.class})
    public ResponseEntity<ErrorMessage> manageMemberNotFoundException(final MemberNotFoundException memberNotFoundException) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(memberNotFoundException.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(value = {EmailAlreadyTakenException.class})
    public ResponseEntity<ErrorMessage> manageEmailAlreadyTakenException(final EmailAlreadyTakenException emailAlreadyTakenException) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(emailAlreadyTakenException.getMessage());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(value = {ErrorDuringPaymentException.class})
    public ResponseEntity<ErrorMessage> manageErrorDuringPaymentException(final ErrorDuringPaymentException errorDuringPaymentException) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(errorDuringPaymentException.getMessage());
        return ResponseEntity.status(402).body(error);
    }

    @ExceptionHandler(value = {PaymentNotValidException.class})
    public ResponseEntity<ErrorMessage> managePaymentNotValidException(final PaymentNotValidException paymentNotValidException) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(paymentNotValidException.getMessage());
        return ResponseEntity.status(402).body(error);
    }
}
