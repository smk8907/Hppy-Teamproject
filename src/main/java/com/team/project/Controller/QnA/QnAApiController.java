package com.team.project.Controller.QnA;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.QnA.QnASaveRequestDto;
import com.team.project.Dto.comment.GalleryCommentSaveRequsetDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.QnA.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/qna")
public class QnAApiController {

    private final QnAService qnAService;

    @PostMapping("/{id}")
    public Long qnaSave(@PathVariable Long id, @RequestBody QnASaveRequestDto requestDto, @LoginUser User user){
        requestDto.setUser(user);

        return qnAService.save(id, requestDto);
    }
}
