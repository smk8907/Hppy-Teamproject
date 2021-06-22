package com.team.project.Controller.Mentor;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.Mentor.MentorSaveRequestDto;
import com.team.project.Dto.Mentor.MentorUpdateRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.Mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class MentorApiController {

    private final MentorService mentorService;

    @PostMapping("/api/v1/mentor")
    public Long mentorsave(@RequestBody MentorSaveRequestDto requestDto, @LoginUser User user){
        requestDto.setUser(user);
        return mentorService.save(requestDto);
    }

    @PutMapping("/api/v1/mentor/{id}")
    public Long update(@PathVariable Long id, @RequestBody MentorUpdateRequestDto requestDto, @LoginUser User user) {
        User mentorAuthor = mentorService.findBoardUserById(id);

        if(!user.getId().equals(mentorAuthor.getId())){
            throw new IllegalStateException("자신의 게시글만 수정할 수 있습니다.");
        }

        return mentorService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/mentor/{id}")
    public Long delete(@PathVariable Long id, @LoginUser User user) {

        User mentorAuthor = mentorService.findBoardUserById(id);

        if(!user.getId().equals(mentorAuthor.getId())){
            throw new IllegalStateException("자신의 게시글만 수정할 수 있습니다.");
        }

        mentorService.delete(id);
        return id;
    }

}
