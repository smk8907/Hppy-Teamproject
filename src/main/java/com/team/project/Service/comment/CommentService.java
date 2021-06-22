package com.team.project.Service.comment;


import com.team.project.Dto.comment.CommentInfoDto;
import com.team.project.Dto.comment.CommentSaveRequestDto;
import com.team.project.Dto.comment.CommentUpdateRequestDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Repository.board.BoardRepository;
import com.team.project.Repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    //댓글 목록 출력
    @Transactional
    public List<CommentInfoDto> getCommentInfo(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + boardId));

        List<Comment> commentsList = commentRepository.findAllByBoardOrderByIdDesc(board);

        List<CommentInfoDto> commentInfoList = new ArrayList<>();

        for (int i = 0; i < commentsList.size(); i++) {
            CommentInfoDto commentInfoDto = new CommentInfoDto();

            Comment comment = commentsList.get(i);
            Long commentUserId = commentsList.get(i).getUser().getId();
            String commentUserName = commentsList.get(i).getUser().getNickname();
            int deleted = commentsList.get(i).getDeleted();

            commentInfoDto.setComment(comment);
            commentInfoDto.setCommentUserId(commentUserId);
            commentInfoDto.setCommentUserName(commentUserName);
            commentInfoDto.setDeleted(deleted);

            commentInfoList.add(commentInfoDto);
        }

        return commentInfoList;
    }

    //댓글 등록
    @Transactional
    public Long save(Long id, CommentSaveRequestDto requestDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 존재하지 않습니다. 게시판 번호 =" + requestDto.getBoardId()));
        requestDto.setBoard(board);

        return commentRepository.save(requestDto.toEntity()).getId();
    }


    //댓글 수정(구현 전)
    @Transactional
    public ResponseEntity<?> update(CommentUpdateRequestDto requestDto){
        Comment comment = commentRepository.findById(requestDto.getCommentId())
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다. 댓글 번호 = " + requestDto.getCommentId()));

        comment.update(requestDto);
        commentRepository.save(comment);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    //댓글 삭제(구현 전)
    @Transactional
    public ResponseEntity<?> delete(Long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다. 댓글 번호 = " + commentId));

        comment.delete(comment);
        commentRepository.save(comment);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    //댓글 유저 출력
    @Transactional
    public Long getCommentUserId(Long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다. 댓글 번호 = " + commentId));

        return comment.getUser().getId();
    }
}
