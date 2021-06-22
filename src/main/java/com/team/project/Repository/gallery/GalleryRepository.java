package com.team.project.Repository.gallery;

import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Gallery.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {


    List<GalleryEntity> findAllByCategoryOrderByIdDesc(Category category);

    List<GalleryEntity> findById(GalleryEntity galleryEntity);


    @Override
    List<GalleryEntity> findAll();


}
