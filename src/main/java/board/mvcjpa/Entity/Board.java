package board.mvcjpa.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "Table_id")
    private Long id;

    private String title;
    private String content;


    public void ChangeBoard(String title,String content){
        this.title = title;
        this.content = content;
    }

    public Board() {
    }

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
