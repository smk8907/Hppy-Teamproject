package com.team.project.Controller.gallery;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.gallery.GalleryDto;
import com.team.project.Dto.gallery.GallerySaveRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import com.team.project.Service.QnA.QnAService;
import com.team.project.Service.S3Service;
import com.team.project.Service.comment.GalleryCommentService;
import com.team.project.Service.gallery.GalleryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class GalleryController {

    private final S3Service s3Service;
    private final GalleryService galleryService;
    private final GalleryCommentService galleryCommentService;
    private final QnAService qnAService;

    @GetMapping("/category/{id}/gallery")
    public String galleryDetail(@PathVariable Long id, Model model, @LoginUser User user) {
        GalleryDto dto = galleryService.findById(id);
        model.addAttribute("gallery", dto);
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("gallerycommentInfoList", galleryCommentService.getGalleryCommentInfo(id));
        model.addAttribute("qnAInfoList", qnAService.getQnAInfo(id));

        return "gallery-detail";
    }

    @PostMapping("/save/category/{id}")
    public String gallerySave(@PathVariable Long id, Model model, GallerySaveRequestDto requestDto, @LoginUser User user, MultipartFile file, MultipartFile file2, MultipartFile file3,
                            MultipartFile file4, MultipartFile file5) throws IOException {

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
        }

        String imgPath = s3Service.upload(requestDto.getFilePath(), file);
        String imgPath2 = s3Service.upload(requestDto.getFilePath2(), file2);
        String imgPath3 = s3Service.upload(requestDto.getFilePath3(), file3);
        String imgPath4 = s3Service.upload(requestDto.getFilePath4(), file4);
        String imgPath5 = s3Service.upload(requestDto.getFilePath5(), file5);

        requestDto.setUser(user);
        requestDto.setFilePath(imgPath);
        requestDto.setFilePath2(imgPath2);
        requestDto.setFilePath3(imgPath3);
        requestDto.setFilePath4(imgPath4);
        requestDto.setFilePath5(imgPath5);
        galleryService.save(id, requestDto);

        return "category/category";
    }

}




