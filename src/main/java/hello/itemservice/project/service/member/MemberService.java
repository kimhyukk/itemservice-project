package hello.itemservice.project.service.member;

import hello.itemservice.project.domain.member.Member;
import hello.itemservice.project.repository.member.MemberRepository;
import hello.itemservice.project.repository.member.SpringDataJpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

//    private final MemberRepository memberRepository;

    private final SpringDataJpaMemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }


    public Optional<Member> findByLoginId(String LoginId) {
        return memberRepository.findById(LoginId);
    }

}
