package io.commerce.server.payment;

import io.commerce.server.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface Payment {
    void verifyIsValid(Member member);
    void processPayment();
}
