package board.mvcjpa.Service;

import board.mvcjpa.Entity.Board;
import board.mvcjpa.Repository.BoardJPARepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import java.util.List;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    EntityManager em;
    @Autowired
    BoardService boardService;
    @Autowired
    BoardJPARepository boardJPARepository;

    @Test
    public void saveTest() throws Exception{
        //given
        Board board = new Board();
        board.setTitle("aa");
        board.setContent("aaa");

        Long id = boardService.saveBoard(board);

//        Optional<Board> boards = boardJPARepository.findById(id);
        Board boards = boardService.findboard(id);
        //when


        Assertions.assertThat(boards.getTitle()).isEqualTo("aa");
        //then
    }

    @Test
    public void deleteTest() throws Exception{
        //given
        Board board = new Board();
        board.setTitle("aa");
        board.setContent("aaa");

        Long id = boardService.saveBoard(board);
        //when
        Board beforeBoards = boardService.findboard(id);
        if(beforeBoards.getId()!=null){
            System.out.println("board is not empty!!!");
        }
        boardService.deleteBoard(id);

        Board boards = boardService.findboard(id);
        if(beforeBoards.getId()==null){
            System.out.println("board is empty!!!");
        }

        //then
    }

    @Test
    public void updateTest() throws Exception{
        //given
        Board board = new Board();
        board.setTitle("aa");
        board.setContent("aaa");

        Long id = boardService.saveBoard(board);

        boardService.updateBoard(id, "bb", "bbb");

        Board boards = boardService.findboard(id);
        Assertions.assertThat(boards.getTitle()).isEqualTo("bb");

        //when

        //then
    }

}