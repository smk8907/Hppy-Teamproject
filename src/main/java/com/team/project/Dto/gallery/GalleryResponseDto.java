package com.team.project.Dto.gallery;

import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;

public class GalleryResponseDto {


    private Long id;
    private String title;
    private String filePath;
    private String imgFullPath;
    private String content;
    private User user;
    private Category category;

    public GalleryResponseDto(GalleryEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.category = entity.getCategory();
        this.user = entity.getUser();
        this.filePath = entity.getFilePath();
    }
}
