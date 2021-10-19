package board.mvcjpa.Entity.Dto;


import board.mvcjpa.Entity.Board;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
public class BoardDto {
    private String title;
    private String content;

    public BoardDto(String title,String content){
        this.title= title;
        this.content = content;
    }

    public BoardDto() {
    }
}
