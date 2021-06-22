package com.team.project.Controller.appl;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.appl.ApplSaveRequsetDto;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.appl.ApplService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appl")
public class ApplApiController {

    private final ApplService applService;

    @PostMapping("/{id}")
    public Long applcommentSave(@PathVariable Long id, @RequestBody ApplSaveRequsetDto requestDto, @LoginUser User user){
        requestDto.setUser(user);

        return applService.save(id, requestDto);
    }

}
