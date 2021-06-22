package com.team.project.Controller.board;




import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.board.BoardResponseDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import com.team.project.Service.board.BoardService;
import com.team.project.Service.comment.CommentService;
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

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    //게시글 리스트 출력
    @GetMapping("/lists")
    public String board(@RequestParam(value = "id", defaultValue = "1") Long id, Model model, @LoginUser User user, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Board> boardList = boardService.getBoardList(pageable);
        boardList.stream().forEach(e -> e.getContent());
        model.addAttribute("viewCount", boardService.updateView(id));
        model.addAttribute("boardList", boardList);
        model.addAttribute("board", boardService.getBoardList(pageable));
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        model.addAttribute("userName", user.getNickname());
        return "list";
    }
    //글 등록
    @GetMapping("/posts/save")
    public String postsSave(@LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getNickname());
            model.addAttribute("userPicture", user.getPicture());
        }

        return "posts-save";
    }
    //댓글 등록(작성창으로 이동)
    @GetMapping("posts/{id}/comment/save")
    public String commentSave(@PathVariable Long id, @LoginUser User user, Model model) {
        if (user != null) {
            model.addAttribute("userName", user.getNickname());
            model.addAttribute("userPicture", user.getPicture());
        }
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "comment-save";
    }
    //게시글 세부 내용보기
    @GetMapping("/posts/{id}")
    public String boardDetail(@PathVariable Long id, Model model, @LoginUser User user) {
        boardService.updateView(id);
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        model.addAttribute("userName", user.getNickname());
        model.addAttribute("userPicture", user.getPicture());
        model.addAttribute("commentInfoList", commentService.getCommentInfo(id));
        return "post-detail";
    }
    //게시글 수정
    @GetMapping("/posts/update/{id}")
    public String boardUpdate(@PathVariable Long id,@LoginUser User user, Model model) {
        BoardResponseDto dto = boardService.findById(id);
        User boardAuthor = boardService.findBoardUserById(id);

        if(!user.getId().equals(boardAuthor.getId())){
            throw new IllegalStateException("자신의 글만 수정할 수 있습니다.");
        }

        model.addAttribute("userName", user.getNickname());
        model.addAttribute("board", dto);
        model.addAttribute("userPicture", user.getPicture());

        return "posts-update";
    }
    //게시글 검색
    @GetMapping("/posts/search")
    public String search(String keyword, Model model) {
        List<Board> searchList = boardService.search(keyword);

        model.addAttribute("searchList", searchList);

        return "searchPage";
    }
}
