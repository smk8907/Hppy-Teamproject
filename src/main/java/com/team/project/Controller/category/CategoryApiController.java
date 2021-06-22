/*package com.team.project.Controller.category;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.gallery.GallerySaveRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.S3Service;
import com.team.project.Service.gallery.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

    private final S3Service s3Service;
    private final GalleryService galleryService;

    @PostMapping("/{id}")
    public Long gallerySave(@PathVariable Long id, Model model, GallerySaveRequestDto requestDto, @LoginUser User user, MultipartFile file, MultipartFile file2, MultipartFile file3,
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

        return galleryService.save(id, requestDto);
    }
} 스크립트문제로 갤러리 컨트롤러로 대체함*/
