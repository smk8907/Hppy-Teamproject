package com.team.project.Controller.Mentor;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.Mentor.MentorResponseDto;
import com.team.project.Entity.Board.Mentor;
import com.team.project.Entity.User.User;
import com.team.project.Service.Mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MentorController {

    private final MentorService mentorService;

    @GetMapping("/mentors")
    public String mentor(@RequestParam(value = "id", defaultValue = "1") Long id, Model model, @LoginUser User user, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Mentor> mentorList = mentorService.getMentorList(pageable);
        mentorList.stream().forEach(e -> e.getContent());

        model.addAttribute("mentorList", mentorList);
        model.addAttribute("mentor", mentorService.getMentorList(pageable));
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "mlist";
    }

    @GetMapping("/mentors/save")
    public String mentorSave(@LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userPicture", user.getPicture());
        }

        return "mentorsave";
    }

    @GetMapping("/mentors/{id}")
    public String mentorDetail(@PathVariable Long id, Model model, @LoginUser User user) {

        MentorResponseDto dto = mentorService.findById(id);
        model.addAttribute("mentor", dto);
        model.addAttribute("userName", user.getName());
        model.addAttribute("userPicture", user.getPicture());

        return "mentor-detail";
    }

    @GetMapping("/mentors/update/{id}")
    public String mentorUpdate(@PathVariable Long id,@LoginUser User user, Model model) {
        MentorResponseDto dto = mentorService.findById(id);
        User mentorAuthor = mentorService.findBoardUserById(id);

        if(!user.getId().equals(mentorAuthor.getId())){
            throw new IllegalStateException("자신의 글만 수정할 수 있습니다.");
        }

        model.addAttribute("mentor", dto);
        model.addAttribute("userPicture", user.getPicture());

        return "mentor-update";
    }
}
