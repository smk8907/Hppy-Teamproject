package com.team.project.Controller.notice;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.notice.NoticeSaveRequestDto;
import com.team.project.Dto.notice.NoticeUpdateRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import com.team.project.Service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/v1/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto, @LoginUser User user){

        return noticeService.save(requestDto);
    }
    //글 수정
    @PutMapping("/api/v1/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateRequestDto requestDto, @LoginUser User user) {

        if(!user.getRole().equals(Role.ADMIN)){
            throw new IllegalStateException("수정 권한이 없습니다.");
        }

        return noticeService.update(id, requestDto);
    }
    //삭제
    @DeleteMapping("/api/v1/notice/{id}")
    public Long delete(@PathVariable Long id, @LoginUser User user) {

        if(!user.getRole().equals(Role.ADMIN)){
            throw new IllegalStateException("삭제 권한이 없습니다.");
        }

        noticeService.delete(id);
        return id;
    }
}
