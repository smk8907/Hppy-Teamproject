package com.team.project.Dto.Mentor;


import com.team.project.Entity.Board.Mentor;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorSaveRequestDto {

    private int career;
    private String title;
    private User user;
    private String htype;
    private String content;

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public MentorSaveRequestDto(String htype, String title, User user, String content, int career) {
        this.htype = htype;
        this.title = title;
        this.user = user;
        this.content = content;
        this.career = career;
    }

    public Mentor toEntity() {
        return Mentor.builder()
                .htype(htype)
                .title(title)
                .user(user)
                .content(content)
                .career(career)
                .build();
    }
}