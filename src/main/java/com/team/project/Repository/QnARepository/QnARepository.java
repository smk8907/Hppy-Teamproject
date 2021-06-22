package com.team.project.Repository.QnARepository;

import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.QnA.QnA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QnARepository extends JpaRepository<QnA, Long> {

        List<QnA> findAllByGalleryEntityOrderByIdDesc(GalleryEntity galleryEntity);
}
