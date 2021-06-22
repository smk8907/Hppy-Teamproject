package com.team.project.Entity.Board;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team.project.Entity.BaseTimeEntity;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.User.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Board extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Lob
    private String content;

    @Column
    private Long viewCount = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> commentsList = new ArrayList<>();

    @Builder
    public Board(String title, String content, User user, List<Comment> commentsList) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.commentsList = commentsList;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
