package io.commerce.api.dto;

import io.commerce.server.member.Member;

import javax.validation.constraints.NotBlank;

public class MemberDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String lastname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String password;
    @NotBlank
    private String card;

    public MemberDTO(){}

    public MemberDTO(final Member member) {
        email = member.getEmail().toString();
        lastname = member.getLastname();
        firstname = member.getFirstname();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
