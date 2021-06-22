package com.team.project.Dto.Mentor;


import com.team.project.Entity.Board.Mentor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorUpdateRequestDto {

    private String htype;
    private String title;
    private String content;
    private int career;

    @Builder
    public MentorUpdateRequestDto(String htype, String title,
                                  String content, int career){
        this.htype = htype;
        this.title = title;
        this.content = content;
        this.career = career;
    }

    public Mentor toEntity() {
        return Mentor.builder()
                .htype(htype)
                .title(title)
                .content(content)
                .career(career)
                .build();
    }
}
