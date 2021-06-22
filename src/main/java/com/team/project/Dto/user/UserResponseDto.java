package com.team.project.Dto.user;

import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;

public class UserResponseDto {

    private Long id;
    private String name;
    private String nickname;
    private String email;
    private String picture;
    private Role role;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.nickname = entity.getNickname();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRole();
    }
}
