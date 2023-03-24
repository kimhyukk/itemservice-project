package hello.itemservice.project.service.login;

import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.repository.member.MemberRepository;
import hello.itemservice.project.repository.member.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SpringDataJpaMemberRepository memberRepository;


    public Member login(String loginId,String password) {

        return memberRepository.findById(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
