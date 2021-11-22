package io.commerce.server.exception;

import java.util.NoSuchElementException;

public class MemberNotFoundException extends NoSuchElementException {
    private final String email;

    public MemberNotFoundException(String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "Member with email: '" + email + "' not found";
    }
}
