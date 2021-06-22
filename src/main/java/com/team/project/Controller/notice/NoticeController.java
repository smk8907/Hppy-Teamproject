package com.team.project.Controller.notice;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.board.BoardResponseDto;
import com.team.project.Dto.notice.NoticeResponseDto;
import com.team.project.Entity.Board.Notice;
import com.team.project.Entity.User.User;
import com.team.project.Enum.Role;
import com.team.project.Service.notice.NoticeService;
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

import static com.team.project.Enum.Role.MASTER;

@RequiredArgsConstructor
@Controller
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public String notice(@RequestParam(value = "id", defaultValue = "1") Long id, Model model, @LoginUser User user, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Notice> noticeList = noticeService.getNoticeList(pageable);
        noticeList.stream().forEach(e -> e.getContent());

        model.addAttribute("noticeList", noticeList);
        model.addAttribute("notice", noticeService.getNoticeList(pageable));
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "nlist";
    }

    @GetMapping("/notices/save")
    public String noticeSave(Model model, @LoginUser User user) {
        model.addAttribute("userPicture", user.getPicture());

        return "notice-save";
    }

    @GetMapping("/notices/{id}")
    public String noticeDetail(@PathVariable Long id, Model model, @LoginUser User user) {

        NoticeResponseDto dto = noticeService.findById(id);
        model.addAttribute("notice", dto);
        model.addAttribute("userPicture", user.getPicture());

        return "notice-detail";
    }

    @GetMapping("/notices/update/{id}")
    public String noticeUpdate(@PathVariable Long id,@LoginUser User user, Model model) {
        NoticeResponseDto dto = noticeService.findById(id);

        if(!user.getRole().equals(Role.ADMIN)){
            throw new IllegalStateException("관리자만 작성할수 있습니다.");
        }

        model.addAttribute("notice", dto);
        model.addAttribute("userPicture", user.getPicture());

        return "notice-update";
    }
}
