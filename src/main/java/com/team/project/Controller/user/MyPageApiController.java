package com.team.project.Controller.user;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.user.UserNicknameDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MyPageApiController {

    private final UserService userService;

    @PutMapping("/api/mypage/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserNicknameDto requestDto, @LoginUser User user) {
        return userService.Mypageupdate(id, requestDto);
    }

    @DeleteMapping("/api/mypage/delete/{id}")
    public Long delete(@PathVariable Long id, @LoginUser User user) {

        userService.delete(id);
        return id;
    }

}
