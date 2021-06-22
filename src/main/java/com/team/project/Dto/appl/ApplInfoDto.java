package com.team.project.Dto.appl;


import com.team.project.Entity.User.User;
import com.team.project.Entity.appliclass.Appl;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplInfoDto {

    private Appl appl;
    private String applcommentUserName;
    private Long applcommentUserId;
    private User applcommentUser;
    private int appldeleted;


    public void setAppl(Appl appl){
        this.appl = appl;
    }


    public void setApplcommentUserName(String applcommentUserName){
        this.applcommentUserName = applcommentUserName;
    }

    public void setApplcommentUserId(Long applcommentUserId){
        this.applcommentUserId = applcommentUserId;
    }

    public void setApplcommentUser(User user){
        this.applcommentUser = user;
    }

    public void setAppldeleted(int appldeleted){ this.appldeleted = appldeleted;}

}


