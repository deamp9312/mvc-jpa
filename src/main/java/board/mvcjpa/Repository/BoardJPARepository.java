package board.mvcjpa.Repository;

import board.mvcjpa.Entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;

public interface BoardJPARepository extends JpaRepository<Board, Long> {


    Board findBoardByid(Long id);
}
