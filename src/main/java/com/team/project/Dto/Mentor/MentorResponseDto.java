package com.team.project.Dto.Mentor;


import com.team.project.Entity.Board.Mentor;
import com.team.project.Entity.User.User;

public class MentorResponseDto {
    private Long id;
    private String title;
    private String content;
    private String htype;
    private User user;
    private int career;

    public MentorResponseDto(Mentor entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.htype = entity.getHtype();
        this.user = entity.getUser();
        this.career = entity.getCareer();
    }
}
