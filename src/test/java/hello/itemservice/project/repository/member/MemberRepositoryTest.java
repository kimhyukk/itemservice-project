package hello.itemservice.project.repository.member;

import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.service.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LoginService loginService;


    @Test
    void findByLoginId() {
        Member test = memberRepository.findByLoginId("test");
        assertThat(test.getPassword()).isEqualTo("1234");
    }

    @Test
    void login() {
        Member test = loginService.login("test", "1234");
        Member test1 = memberRepository.findByLoginId("test");
        assertThat(test).isEqualTo(test1);
    }
}