package hello.itemservice.project.repository.member;

import hello.itemservice.project.domain.member.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemberRepository {

    private final JdbcTemplate template;


    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    public void save(Member member) {
        template.update("insert into member(login_id,password) values (?,?)", member.getLoginId(), member.getPassword());
    }

    public Member findByLoginId(String loginId) {
        Member member = template.queryForObject("select login_id, password from member where login_id=?",
                BeanPropertyRowMapper.newInstance(Member.class),
                loginId);
        return member;
    }

    public List<Member> findAll() {
        return template.query("select member_id, password from member",
                BeanPropertyRowMapper.newInstance(Member.class));
    }


}
