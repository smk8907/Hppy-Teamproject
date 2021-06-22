package com.team.project.Dto.notice;



import com.team.project.Entity.Board.Notice;

public class NoticeResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;


    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
