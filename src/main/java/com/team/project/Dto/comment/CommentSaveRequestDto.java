package com.team.project.Dto.comment;

import com.team.project.Entity.Board.Board;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private Long boardId;
    private Board board;
    private User user;
    private int sequence;
    private String content;


    public void setUser(User user){
        this.user = user;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    @Builder
    public CommentSaveRequestDto(Board board, User user, int sequence, String content){
        this.board = board;
        this.user = user;
        this.sequence = sequence;
        this.content = content;
    }

    public Comment toEntity() {
        return Comment.builder()
                .board(board)
                .user(user)
                .sequence(sequence)
                .content(content)
                .build();
    }
}