package com.team.project.Dto.user;


import com.team.project.Entity.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserNicknameDto {

    private Long id;
    private String nickname;

    public UserNicknameDto(Long id, String nickname){

        this.id = id;
        this.nickname = nickname;

    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .nickname(nickname)
                .build();
    }
}
