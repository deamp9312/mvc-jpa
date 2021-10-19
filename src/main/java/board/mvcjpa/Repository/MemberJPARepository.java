package board.mvcjpa.Repository;

import board.mvcjpa.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJPARepository extends JpaRepository<Member,Long> {
}
