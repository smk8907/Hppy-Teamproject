package com.team.project.Dto.comment;

import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentInfoDto {

    private Comment comment;
    private String commentUserName;
    private Long commentUserId;
    private User commentUser;
    private int deleted;

    public void setComment(Comment comment){
        this.comment = comment;
    }

    public void setCommentUserName(String commentUserName){
        this.commentUserName = commentUserName;
    }

    public void setCommentUserId(Long commentUserId){
        this.commentUserId = commentUserId;
    }

    public void setCommentUser(User user){
        this.commentUser = user;
    }

    public void setDeleted(int deleted){ this.deleted = deleted;}

}
