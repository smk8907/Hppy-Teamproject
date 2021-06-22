package com.team.project.Repository.appl;

import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.appliclass.Appl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplRepository extends JpaRepository<Appl, Long> {

        List<Appl> findAllByGalleryEntityOrderByIdAsc(GalleryEntity galleryEntity);
}
