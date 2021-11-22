package io.commerce.server.repository;

import io.commerce.server.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    List<Member> getMembers();
    void addMember(Member member);
    void deleteMemberByEmail(String email);
}
