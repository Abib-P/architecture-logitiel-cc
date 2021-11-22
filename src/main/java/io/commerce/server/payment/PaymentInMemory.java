package io.commerce.server.payment;

import io.commerce.server.exception.ErrorDuringPaymentException;
import io.commerce.server.exception.PaymentNotValidException;
import io.commerce.server.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentInMemory implements Payment{
    @Override
    public void verifyIsValid(Member member) {
        //throw new PaymentNotValidException("message");
    }

    @Override
    public void processPayment() {
        //throw new ErrorDuringPaymentException("message");
    }
}
