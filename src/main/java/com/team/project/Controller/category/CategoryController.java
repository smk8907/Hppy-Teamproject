package com.team.project.Controller.category;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.category.CategoryResponseDto;
import com.team.project.Dto.gallery.GalleryDto;
import com.team.project.Dto.user.UserResponseDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.category.CategoryService;
import com.team.project.Service.gallery.GalleryService;
import com.team.project.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final GalleryService galleryService;


    @GetMapping("/category")
    public String category(@LoginUser User user, Model model){
        model.addAttribute("userPicture", user.getPicture());
        return "category/category";
    }

    @GetMapping("category/save/{id}")
    public String categorySave(@PathVariable Long id, @LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
            model.addAttribute("userPicture", user.getPicture());
        }



        model.addAttribute("categoryId", id);
        return "gallery-save";
    }

    @GetMapping("/category/{id}")
    public String categoryDetail(@PathVariable Long id, Model model, @LoginUser User user) {
        CategoryResponseDto dto = categoryService.findById(id);
        model.addAttribute("category", dto);
        model.addAttribute("galleryDtoList", galleryService.getList(id));
        model.addAttribute("userPicture", user.getPicture());
        return "category-detail";
    }

    @GetMapping("category/{id}/{id}/gallerycomment/save")
    public String gallerycommentSave(@PathVariable Long id, @LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getNickname());
            model.addAttribute("userPicture", user.getPicture());
        }
        GalleryDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        return "gallerycomment-save";
    }

    @GetMapping("category/{id}/{id}/qna/save")
    public String qnaSave(@PathVariable Long id, @LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getNickname());
            model.addAttribute("userPicture", user.getPicture());
        }
        GalleryDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        return "qna-save";
    }

    @GetMapping("category/{id}/{id}/appls/save")
    public String applSave(@PathVariable Long id, @LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userPicture", user.getPicture());
        }
        GalleryDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        return "appl-save";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
                return "accessDenied";
    }
}
