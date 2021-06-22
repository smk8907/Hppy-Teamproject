package com.team.project.Dto.notice;



import com.team.project.Entity.Board.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeSaveRequestDto {

    private String title;
    private String author;
    private String content;


    @Builder
    public NoticeSaveRequestDto(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Notice toEntity() {
        return Notice.builder()

                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}