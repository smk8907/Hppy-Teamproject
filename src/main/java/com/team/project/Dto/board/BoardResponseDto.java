package com.team.project.Dto.board;


import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;

public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long viewCount;
    private User user;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.viewCount = entity.getViewCount();
        this.user = entity.getUser();
    }
}
