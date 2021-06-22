package com.team.project.Controller.admin;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.user.UserRoleUpDateDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.board.BoardService;
import com.team.project.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AdminApiController {

    private final UserService userService;
    private final BoardService boardService;

    @PutMapping("/user/role/{id}")
    public Long RoleUpdate(@PathVariable Long id, @RequestBody UserRoleUpDateDto requestDto) {
        return userService.roleUpdate(id, requestDto);
    }

    @DeleteMapping("/user/delete/{id}")
    public Long delete(@PathVariable Long id) {

        userService.delete(id);
        return id;
    }

    @DeleteMapping("/board/delete/{id}")
    public Long admindelete(@PathVariable Long id) {

        boardService.delete(id);
        return id;
    }
}

