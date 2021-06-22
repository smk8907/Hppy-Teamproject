package com.team.project.Repository.board;

import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByUser(User user);

    @Query("SELECT p FROM Board p order by p.createdDate DESC ")
    Page<Board> findAllDesc(Pageable pageable);

    List<Board> findByTitleContaining(String keyword);

    @Modifying
    @Query("update Board b set b.viewCount = b.viewCount + 1 where b.id = :id")
    int updateView(Long id);

}
