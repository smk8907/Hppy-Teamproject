package com.team.project.Dto.gallery;

import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GallerySaveRequestDto {
    private Long categoryId;
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
    private int sequence;
    private Category category;

    public void setUser(User user) {
        this.user = user;
    }
    public void setCategory(Category category) {this.category = category;}

    public void setFilePath(String filePath) {this.filePath = filePath;}
    public void setFilePath2(String filePath2) {this.filePath2 = filePath2;}
    public void setFilePath3(String filePath3) {this.filePath3 = filePath3;}
    public void setFilePath4(String filePath4) {this.filePath4 = filePath4;}
    public void setFilePath5(String filePath5) {this.filePath5 = filePath5;}

    @Builder
    public GallerySaveRequestDto(String title, String filePath, String filePath2, String filePath3, String filePath4, String filePath5, String imgFullPath, String imgFullPath2, String imgFullPath3,String imgFullPath4,String imgFullPath5, User user, int sequence, String content, Category category){
        this.title = title;
        this.user = user;
        this.filePath = filePath;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
        this.filePath4 = filePath4;
        this.filePath5 = filePath5;
        this.imgFullPath2 = imgFullPath2;
        this.imgFullPath3 = imgFullPath3;
        this.imgFullPath4 = imgFullPath4;
        this.imgFullPath5 = imgFullPath5;
        this.sequence = sequence;
        this.content = content;
        this.imgFullPath = imgFullPath;
        this.category = category;

    }

    public GalleryEntity toEntity() {
        return GalleryEntity.builder()
                .title(title)
                .category(category)
                .user(user)
                .sequence(sequence)
                .content(content)
                .filePath(filePath)
                .filePath2(filePath2)
                .filePath3(filePath3)
                .filePath4(filePath4)
                .filePath5(filePath5)
                .build();
    }
}

