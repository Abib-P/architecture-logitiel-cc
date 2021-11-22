package io.commerce.server.repository;

import io.commerce.server.exception.MemberNotFoundException;
import io.commerce.server.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepositoryInMemory implements MemberRepository {
    final private List<Member> members;

    MemberRepositoryInMemory() {
        this.members = new ArrayList<>();
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }

    @Override
    public void addMember(final Member member) {
        members.add(member);
    }

    @Override
    public void deleteMemberByEmail(final String email) {
        Member memberToDelete = members.stream()
                .filter(member -> member.getEmail().toString().equals(email))
                .findFirst()
                .orElseThrow(() -> new MemberNotFoundException(email));
        members.remove(memberToDelete);
    }
}
