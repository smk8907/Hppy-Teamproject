package com.team.project.Dto.comment;


import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GalleryCommentInfoDto {

    private GalleryComment galleryComment;
    private String gallerycommentUserName;
    private Long gallerycommentUserId;
    private User gallerycommentUser;
    private int gallerydeleted;


    public void setGalleryComment(GalleryComment galleryComment){
        this.galleryComment = galleryComment;
    }

    public void setGallerycommentUserName(String gallerycommentUserName){
        this.gallerycommentUserName = gallerycommentUserName;
    }

    public void setGallerycommentUserId(Long gallerycommentUserId){
        this.gallerycommentUserId = gallerycommentUserId;
    }

    public void setGallerycommentUser(User user){
        this.gallerycommentUser = user;
    }

    public void setGallerydeleted(int gallerydeleted){ this.gallerydeleted = gallerydeleted;}

}

