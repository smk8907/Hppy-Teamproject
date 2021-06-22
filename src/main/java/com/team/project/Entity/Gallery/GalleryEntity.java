package com.team.project.Entity.Gallery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team.project.Entity.Category.Category;
import com.team.project.Entity.Comment.GalleryComment;
import com.team.project.Entity.QnA.QnA;
import com.team.project.Entity.User.User;
import com.team.project.Entity.appliclass.Appl;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "gallery")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class GalleryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "gid")
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String filePath;


    @Column(columnDefinition = "TEXT")
    private String filePath2;

    @Column(columnDefinition = "TEXT")
    private String filePath3;


    @Column(columnDefinition = "TEXT")
    private String filePath4;

    @Column(columnDefinition = "TEXT")
    private String filePath5;

    @Lob
    private String content;

    @Column
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    private Category category;

    @OneToMany(mappedBy = "galleryEntity", cascade = CascadeType.ALL)
    private List<GalleryComment> galleryCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "galleryEntity", cascade = CascadeType.ALL)
    private List<Appl> applList = new ArrayList<>();

    @OneToMany(mappedBy = "galleryEntity", cascade = CascadeType.ALL)
    private List<QnA> qnAList = new ArrayList<>();

    @Builder
    public GalleryEntity(Long id, String title, int sequence, String content, String filePath, String filePath2, String filePath3, String filePath4, String filePath5, User user, Category category, List<GalleryComment> galleryCommentList, List<QnA> qnAList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.filePath2 = filePath2;
        this.filePath3 = filePath3;
        this.filePath4 = filePath4;
        this.filePath5 = filePath5;
        this.user = user;
        this.category = category;
        this.sequence = sequence;
        this.galleryCommentList = galleryCommentList;
        this.qnAList = qnAList;
    }
}
