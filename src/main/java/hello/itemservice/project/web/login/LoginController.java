package hello.itemservice.project.web.login;


import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.service.login.LoginService;
import hello.itemservice.project.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form)   {
        return "/login/loginForm";
    }


    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request,
                        @RequestParam(defaultValue = "/") String url) {

        if (bindingResult.hasErrors()) {
            log.info("에러발생 errors={}", bindingResult);
            return "/login/loginForm";
        }

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login/loginForm";
        }

        //로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        //쿠키에 시간정보를 주지 않으면 세션 쿠키

        return "redirect:"+url;
    }



    @PostMapping("/logout")
    public String logout(HttpServletRequest request)    {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
