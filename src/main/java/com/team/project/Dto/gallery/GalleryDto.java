package com.team.project.Dto.gallery;

import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalleryDto {

    private Long id;
    private String title;
    private String filePath;
    private String filePath2;
    private String filePath3;
    private String filePath4;
    private String filePath5;
    private String imgFullPath;
    private String imgFullPath2;
    private String imgFullPath3;
    private String imgFullPath4;
    private String imgFullPath5;
    private String content;
    private User user;
    private Category category;
    private GalleryEntity galleryEntity;

    public void setGallery(GalleryEntity galleryEntity) {
        this.galleryEntity = galleryEntity;
    }


    public GalleryEntity toEntity() {

        GalleryEntity build = GalleryEntity.builder()
                .id(id)
                .title(title)
                .filePath(filePath)
                .filePath2(filePath2)
                .filePath3(filePath3)
                .filePath4(filePath4)
                .filePath5(filePath5)
                .content(content)
                .user(user)
                .category(category)
                .build();
        return build;
    }

    @Builder
    public GalleryDto(Long id, String title, String filePath, String filePath2, String filePath3, String filePath4, String filePath5, String imgFullPath2, String imgFullPath3,String imgFullPath4,String imgFullPath5, String content, String imgFullPath, User user, Category category) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
        this.filePath4 = filePath4;
        this.filePath5 = filePath5;
        this.imgFullPath = imgFullPath;
        this.imgFullPath2 = imgFullPath2;
        this.imgFullPath3 = imgFullPath3;
        this.imgFullPath4 = imgFullPath4;
        this.imgFullPath5 = imgFullPath5;
        this.user = user;
        this.category = category;
        this.content = content;
    }

    public GalleryDto(GalleryEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.category = entity.getCategory();
        this.user = entity.getUser();
        this.filePath = entity.getFilePath();
        this.filePath2 = entity.getFilePath2();
        this.filePath3 = entity.getFilePath3();
        this.filePath4 = entity.getFilePath4();
        this.filePath5 = entity.getFilePath5();

    }
}
