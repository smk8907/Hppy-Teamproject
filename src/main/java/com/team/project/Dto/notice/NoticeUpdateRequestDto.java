package com.team.project.Dto.notice;


import com.team.project.Entity.Board.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public NoticeUpdateRequestDto(String title,
                                  String content){
        this.title = title;
        this.content = content;
    }

    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .build();
    }
}
