package com.team.project.Dto.QnA;


import com.team.project.Entity.QnA.QnA;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class QnAInfoDto {

    private QnA qnA;
    private String qnaUserName;
    private Long qnaUserId;


    public void setQnA(QnA qnA){
        this.qnA = qnA;
    }

    public void setQnaUserName(String qnaUserName){
        this.qnaUserName = qnaUserName;
    }

    public void setQnaUserId(Long qnaUserId){
        this.qnaUserId = qnaUserId;
    }

}
