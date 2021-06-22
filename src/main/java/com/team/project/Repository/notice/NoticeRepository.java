package com.team.project.Repository.notice;

import com.team.project.Entity.Board.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT p FROM Notice p order by p.createdDate DESC ")
    Page<Notice> findAllDesc(Pageable pageable);
}
