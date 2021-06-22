package com.team.project.Dto.user;


import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRoleUpDateDto {

    private Long id;
    private Role role;

    public UserRoleUpDateDto(Long id, Role role){

        this.id = id;
        this.role = role;

    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .role(role)
                .build();

    }
}
