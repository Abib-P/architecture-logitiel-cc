package io.commerce.server.member;

public class Member {
    private final Email email;
    private final String lastname;
    private final String firstname;
    private final String password;
    private final String card;

    public Member(final String email, final String lastname, final String firstname, final String password, final String card) {
        this.email = new Email(email);
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.card = card;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCard() {
        return card;
    }
}
