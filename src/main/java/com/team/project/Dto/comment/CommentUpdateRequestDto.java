package com.team.project.Dto.comment;

import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequestDto {
    private Long commentId;
    private Long boardId;
    private Board board;
    private User user;
    private String content;

    public void setUser(User user){
        this.user = user;
    }
}