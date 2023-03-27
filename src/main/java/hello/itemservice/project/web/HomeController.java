package hello.itemservice.project.web;

import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.web.login.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping
public class HomeController {


//    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/")
    public String homeLoginV3Spring(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
            Model model)
    {

        // 세션에 회원 데이터가 없으면 홈으로
        if (loginMember == null) {
            model.addAttribute("loginForm", new LoginForm());
            return "redirect:/login";
        }

        //회원 데이터 조회 성공
        model.addAttribute("member", loginMember);

        return "/login/loginHome";
    }
}
