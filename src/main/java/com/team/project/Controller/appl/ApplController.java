package com.team.project.Controller.appl;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.gallery.GalleryDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.appl.ApplService;
import com.team.project.Service.gallery.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ApplController {

    private final GalleryService galleryService;
    private final ApplService applService;

    @GetMapping("/category/{id}/appl/{id}")
    public String applDetail(@PathVariable Long id, Model model, @LoginUser User user) {
        GalleryDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("apllInfoList", applService.getApplInfo(id));

        return "appl-list";
    }
}
