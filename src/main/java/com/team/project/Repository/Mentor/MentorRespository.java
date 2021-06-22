package com.team.project.Repository.Mentor;

import com.team.project.Entity.Board.Mentor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MentorRespository extends JpaRepository<Mentor, Long> {

    @Query("SELECT p FROM Mentor p order by p.modifiedDate DESC ")
    Page<Mentor> findAllDesc(Pageable pageable);
}

