package com.team.project.Controller.admin;

import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.board.BoardResponseDto;
import com.team.project.Dto.user.UserResponseDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import com.team.project.Service.board.BoardService;
import com.team.project.Service.comment.CommentService;
import com.team.project.Service.user.UserService;
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

public class AdminController {

    private final UserService userService;
    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/admin/users/list")
    public String getUserList(@PageableDefault Pageable pageable, Model model){
        model.addAttribute("userList", userService.getUserList(pageable));
        return "userList";
    }

    @GetMapping({"/admin/user", "/admin/user/"})
    public String getUserDetail(@RequestParam(value = "id", defaultValue = "0") Long id, Model model,@LoginUser User user){
        UserResponseDto dto = userService.findById(id);
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("userInfo", dto);
        return "userUpdate";
    }

    @GetMapping("/admin/board/lists")
    public String board(@RequestParam(value = "id", defaultValue = "1") Long id, Model model, @LoginUser User user, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Board> boardList = boardService.getBoardList(pageable);
        boardList.stream().forEach(e -> e.getContent());
        model.addAttribute("viewCount", boardService.updateView(id));
        model.addAttribute("boardList", boardList);
        model.addAttribute("board", boardService.getBoardList(pageable));
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "boardlist";
    }

    @GetMapping("/admin/posts/{id}")
    public String boardDetail(@PathVariable Long id, Model model, @LoginUser User user) {
        boardService.updateView(id);
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        model.addAttribute("userName", user.getNickname());
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("commentInfoList", commentService.getCommentInfo(id));
        return "apost-detail";
    }
}