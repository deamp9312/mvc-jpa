package board.mvcjpa.Controller;


import board.mvcjpa.Entity.Board;
import board.mvcjpa.Entity.Dto.BoardDto;
import board.mvcjpa.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostConstruct
    public void init() {

        boardService.saveBoard(new Board("Atitle", "aaaa"));
        boardService.saveBoard(new Board("Btitle", "bbbb"));
    }

    @GetMapping("/boards")
    public String boards(Model model) {
        log.info("boards 실행");

        List<Board> boards = boardService.findboards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("/board/new")
    public String create(Model model) {
        model.addAttribute("form", new Board());
        return "boards/boardNew";
    }

    @PostMapping("/board/new")
    public String create(@ModelAttribute("form") BoardDto form) {
        log.info("title : " + form.getTitle());
        log.info("content : " + form.getContent());
        Board board = new Board(form.getTitle(), form.getContent());
        boardService.saveBoard(board);
        return "redirect:/boards";
    }

    @DeleteMapping("/board/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        log.info("remove : " + id);
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }

    @GetMapping("/board/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Board findboard = boardService.findboard(id);
        BoardDto form = new BoardDto();
        form.setTitle(findboard.getTitle());
        form.setContent(findboard.getContent());
        model.addAttribute("form", form);
        return "boards/boardEdit";
    }

//="@{/board/{id}/edit (id=${form.id})}"

// <a href="#" th:href="@{/board/{id}/edit (id=${board.id})}"
//                        role="button">수정</a>
    @PutMapping("/board/{id}/edit")
    public String edit(@PathVariable("id") Long id,@ModelAttribute("form") BoardDto form) {
        Board findboard = boardService.findboard(id);
        findboard.setTitle(form.getTitle());
        findboard.setContent(form.getContent());
        boardService.saveBoard(findboard);
        return "redirect:/boards";
    }


}
