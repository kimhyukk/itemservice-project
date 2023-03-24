package hello.itemservice.project.repository.member;

import hello.itemservice.project.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,String> {
}
