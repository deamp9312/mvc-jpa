package board.mvcjpa.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "Member_id")
    private Long id;

    private String username;
    private String password;

}
