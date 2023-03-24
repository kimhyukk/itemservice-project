package hello.itemservice.project.domain.member;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {


    @Id
    private String loginId;
    private String password;

}
