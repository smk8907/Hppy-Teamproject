package com.team.project.Dto.board;


import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private User user;
    private String content;

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public BoardSaveRequestDto(String title, User user, String content) {
        this.title = title;
        this.user = user;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .user(user)
                .content(content)
                .build();
    }
}