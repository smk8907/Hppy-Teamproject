package com.team.project.Entity.Comment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team.project.Dto.comment.CommentUpdateRequestDto;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Comment {

    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @Column
    private int sequence;

    @Lob
    private String content;

    @Column(columnDefinition = "int default 0")
    private int deleted;

    @Column(columnDefinition = "int default 0")
    private int updated;

    public void update(CommentUpdateRequestDto requestDto){
        this.content = requestDto.getContent();
    }

    public void delete(Comment comment){
        this.deleted = 1;
    }

    @Builder
    public Comment(Board board, User user, int sequence, String content){
        this.board = board;
        this.user = user;
        this.sequence = sequence;
        this.content = content;
    }
}

