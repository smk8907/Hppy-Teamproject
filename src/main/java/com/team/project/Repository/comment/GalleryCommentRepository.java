package com.team.project.Repository.comment;

import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryCommentRepository extends JpaRepository<GalleryComment, Long> {

    List<GalleryComment> findAllByGalleryEntityOrderByIdDesc(GalleryEntity galleryEntity);
}
