package com.team.project.Dto.user;

import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private Long id;
    private String name;
    private String picture;
    private String nickname;
    private Role role;
    private LocalDateTime createdDate;

    public UserUpdateRequestDto(Long  id, String name, String nickname, String picture, Role role, LocalDateTime createdDate) {
        this.name = name;
        this.picture = picture;
        this.id = id;
        this.nickname = nickname;
        this.role = role;
        this.createdDate = createdDate;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .name(name)
                .picture(picture)
                .nickname(nickname)
                .role(role)
                .build();

    }
}
