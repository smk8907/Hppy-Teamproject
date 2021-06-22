package com.team.project.Controller.category;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.comment.GalleryCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/gallerycomments")
public class GalleryCommentApiController {

    private final GalleryCommentService galleryCommentService;

    @PostMapping("/{id}")
    public Long gallerycommentSave(@PathVariable Long id, @RequestBody GalleryCommentSaveRequsetDto requestDto, @LoginUser User user){
        requestDto.setUser(user);

        return galleryCommentService.save(id, requestDto);
    }

}
