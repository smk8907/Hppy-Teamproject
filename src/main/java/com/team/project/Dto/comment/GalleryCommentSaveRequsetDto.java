package com.team.project.Dto.comment;


import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryCommentSaveRequsetDto {

    private Long galleryId;
    private GalleryEntity galleryEntity;
    private User user;
    private int sequence;
    private String content;

    public void setUser(User user){
        this.user = user;
    }

    public void setGalleryEntity(GalleryEntity galleryEntity){
        this.galleryEntity = galleryEntity;
    }

    @Builder
    public GalleryCommentSaveRequsetDto(GalleryEntity galleryEntity, User user, int sequence, String content){
        this.galleryEntity = galleryEntity;
        this.user = user;
        this.sequence = sequence;
        this.content = content;

    }

    public GalleryComment toEntity() {
        return GalleryComment.builder()

                .galleryEntity(galleryEntity)
                .user(user)
                .sequence(sequence)
                .content(content)
                .build();
    }
}

