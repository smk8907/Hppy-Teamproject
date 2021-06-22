package com.team.project.Controller.user;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.user.UserResponseDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class MyPageController {

    private final UserService userService;

    @GetMapping("/mypage")
    public String mypage(Model model, @LoginUser User user) {
        model.addAttribute("userId", user.getId());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userNickname", user.getNickname());
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("userRole", user.getRole());

        return "mypage";
    }

    @GetMapping("/mypage/update/{id}")
    public String mypageupdate(@PathVariable Long id, @LoginUser User user, Model model) {
        UserResponseDto dto = userService.findById(id);
        model.addAttribute("user", dto);
        model.addAttribute("userPicture", user.getPicture());

        return "mypage-update";
    }
}
