package com.team.project.Entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team.project.Entity.BaseTimeEntity;
import com.team.project.Entity.Board.Board;
import com.team.project.Entity.Board.Mentor;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.QnA.QnA;
import com.team.project.Entity.appliclass.Appl;
import com.team.project.Enum.Role;
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
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String nickname;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appl> applList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mentor> mentorList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GalleryEntity> galleryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GalleryComment> galleryCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QnA> qnAList = new ArrayList<>();

    @Builder
    public User(Long id, String name,String email, String nickname, String picture, Role role, List<Board> boardList, List<Comment> commentsList, List<GalleryEntity> galleryEntityList, List<Mentor> mentorList, List<GalleryComment> galleryCommentList, List<QnA> qnAList) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.boardList = boardList;
        this.commentsList = commentsList;
        this.galleryEntityList = galleryEntityList;
        this.mentorList = mentorList;
        this.galleryCommentList = galleryCommentList;
        this.qnAList = qnAList;
    }


    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public void roleUpdate(Role role){
        this.role = role;
    }

    public void mypageUpdate(String nickname){
        this.nickname = nickname;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
