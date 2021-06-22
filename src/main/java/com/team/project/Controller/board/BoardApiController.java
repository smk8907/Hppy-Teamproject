package com.team.project.Controller.board;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.board.BoardSaveRequestDto;
import com.team.project.Dto.board.BoardUpdateRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    //글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody BoardSaveRequestDto requestDto, @LoginUser User user){
        requestDto.setUser(user);
        return boardService.save(requestDto);
    }
    //글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto, @LoginUser User user) {

        User boardAuthor = boardService.findBoardUserById(id);

        if(!user.getId().equals(boardAuthor.getId())){
            throw new IllegalStateException("자신의 게시글만 수정할 수 있습니다.");
        }

        return boardService.update(id, requestDto);
    }
    //삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id, @LoginUser User user) {

        User boardAuthor = boardService.findBoardUserById(id);

        if(!user.getId().equals(boardAuthor.getId())){
            throw new IllegalStateException("자신의 게시글만 삭제 할 수 있습니다.");
        }

        boardService.delete(id);
        return id;
    }

}
