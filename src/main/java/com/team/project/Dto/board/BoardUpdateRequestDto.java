package com.team.project.Dto.board;


import com.team.project.Entity.Board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Transactional
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto (String title,
                                  String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
