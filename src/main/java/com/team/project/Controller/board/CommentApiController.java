package com.team.project.Controller.board;


import com.team.project.Config.Auth.LoginUser;
import com.team.project.Dto.comment.CommentSaveRequestDto;
import com.team.project.Dto.comment.CommentUpdateRequestDto;
import com.team.project.Entity.User.User;
import com.team.project.Service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentApiController {

    private final CommentService commentService;

    //댓글 등록
    @PostMapping("/{id}")
    public Long commentSave(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto, @LoginUser User user){
        requestDto.setUser(user);
        return commentService.save(id, requestDto);
    }
    //댓글 수정(구현 전)
    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@RequestBody CommentUpdateRequestDto requestDto, @LoginUser User user){
        Long userId = commentService.getCommentUserId(requestDto.getCommentId());

        if(!user.getId().equals(userId)){
            throw new IllegalStateException("자신의 댓글만 수정 할 수 있습니다.");
        }

        requestDto.setUser(user);
        return commentService.update(requestDto);
    }

    //댓글 삭제(구현 전)
    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Long commentId, @LoginUser User user){
        Long userId = commentService.getCommentUserId(commentId);

        if(!user.getId().equals(userId)){
            throw new IllegalStateException("자신의 댓글만 삭제 할 수 있습니다.");
        }

        return commentService.delete(commentId);
    }
}

