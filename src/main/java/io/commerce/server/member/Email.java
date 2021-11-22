package io.commerce.server.member;

public class Email {
    private final String email;

    public Email(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }
}
