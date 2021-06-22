package com.team.project.Dto.appl;


import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;
import com.team.project.Entity.appliclass.Appl;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplSaveRequsetDto {

    private Long galleryId;
    private GalleryEntity galleryEntity;
    private User user;
    private int sequence;
    private String content;
    private String title;

    public void setUser(User user){
        this.user = user;
    }

    public void setGalleryEntity(GalleryEntity galleryEntity){
        this.galleryEntity = galleryEntity;
    }

    @Builder
    public ApplSaveRequsetDto(GalleryEntity galleryEntity, User user, int sequence, String content, String title){
        this.galleryEntity = galleryEntity;
        this.user = user;
        this.sequence = sequence;
        this.content = content;
        this.title = title;

    }

    public Appl toEntity() {
        return Appl.builder()

                .galleryEntity(galleryEntity)
                .user(user)
                .sequence(sequence)
                .content(content)
                .title(title)
                .build();
    }
}

