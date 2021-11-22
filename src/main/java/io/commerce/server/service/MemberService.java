package io.commerce.server.service;

import io.commerce.server.exception.EmailAlreadyTakenException;
import io.commerce.server.exception.MemberNotFoundException;
import io.commerce.server.payment.Payment;
import io.commerce.server.repository.MemberRepository;
import io.commerce.server.member.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final Payment payment;

    public MemberService(final MemberRepository memberRepository, final Payment payment) {
        this.memberRepository = memberRepository;
        this.payment = payment;
    }

    public List<Member> geMembers() {
        return memberRepository.getMembers();
    }

    public Member getMember(final String email) {
        return memberRepository.getMembers().stream()
                .filter(member -> member.getEmail().toString().equals(email))
                .findFirst()
                .orElseThrow(() -> new MemberNotFoundException(email));
    }

    public void addMember(final Member member) {
        Optional<Member> optionalMember = memberRepository.getMembers().stream()
                .filter(member1 -> member1.getEmail().equals(member.getEmail()))
                .findFirst();
        payment.verifyIsValid(member);
        if (optionalMember.isPresent()) {
            throw new EmailAlreadyTakenException(member.getEmail().toString());
        }
    }

    public void deleteMember(final String email) {
        memberRepository.deleteMemberByEmail(email);
    }
}
