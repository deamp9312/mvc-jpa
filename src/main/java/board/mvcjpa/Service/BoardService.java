package board.mvcjpa.Service;


import board.mvcjpa.Entity.Board;
import board.mvcjpa.Repository.BoardJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BoardService {
    @Autowired
    BoardJPARepository boardJPARepository;


    public Board findboard(Long id) {
        return boardJPARepository.findBoardByid(id);
    }

    public List<Board> findboards() {
        return boardJPARepository.findAll();
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardJPARepository.deleteById(id);
    }

    @Transactional
    public Long saveBoard(Board board) {
        boardJPARepository.save(board);
        return board.getId();
    }

    @Transactional
    public void updateBoard(Long boardId, String boardTitle, String boardContent) {

//        Optional<Board> findBoard = boardJPARepository.findById(boardId);
        Board findBoard = boardJPARepository.findBoardByid(boardId);
        findBoard.setTitle(boardTitle);
        findBoard.setContent(boardContent);
       /* findBoard.get().setTitle(boardTitle);
        findBoard.get().setContent(boardContent);*/
        boardJPARepository.save(findBoard); //둘다 되요

    }


}
