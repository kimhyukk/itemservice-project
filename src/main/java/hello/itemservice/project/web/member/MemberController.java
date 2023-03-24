package hello.itemservice.project.web.member;

import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/add")
    public String addMemberForm(@ModelAttribute Member member) {
        return "/members/addMemberForm";
    }


    @PostMapping("/members/add")
    public String addMember(@ModelAttribute Member member) {
        memberService.save(member);
        return "redirect:/login";
    }
}
