package com.team.project.Controller;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Entity.User.User;
import com.team.project.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final UserService userService;

    @GetMapping("/main")
    public String main(@LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user);
            model.addAttribute("userPicture", user.getPicture());
        }

        return "main";
    }
}


