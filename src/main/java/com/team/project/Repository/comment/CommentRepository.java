package com.team.project.Repository.comment;

import com.team.project.Entity.Board.Board;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByBoardOrderByIdDesc(Board board, Pageable pageable);
    List<Comment> findAllByBoardOrderByIdDesc(Board board);
    List<User> findUserByBoardOrderByIdDesc(Board board);
}
