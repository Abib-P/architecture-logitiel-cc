package io.commerce.api.controller;

import io.commerce.api.dto.SubscriptionDTO;
import io.commerce.api.dto.MemberDTO;
import io.commerce.server.service.MemberService;
import io.commerce.server.member.Member;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MemberController extends ErrorHandler {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members")
    public List<MemberDTO> getMembers() {
        return memberService.geMembers().stream().map(MemberDTO::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/members/{email}")
    public MemberDTO getMember(@PathVariable @Valid String email) {
        return new MemberDTO(memberService.getMember(email));
    }

    @PostMapping(value = "/members")
    public SubscriptionDTO subscribeMember(@RequestBody @Valid MemberDTO memberDTO) {
        Member member = new Member(
                memberDTO.getEmail(),
                memberDTO.getLastname(),
                memberDTO.getFirstname(),
                memberDTO.getPassword(),
                memberDTO.getCard()
        );
        memberService.addMember(member);
        return new SubscriptionDTO();
    }

    @DeleteMapping(value = "/members/{email}")
    public void deleteMember(@PathVariable @Valid String email) {
        memberService.deleteMember(email);
    }
}