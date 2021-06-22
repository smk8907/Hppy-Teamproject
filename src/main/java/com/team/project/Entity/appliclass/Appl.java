package com.team.project.Entity.appliclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.team.project.Dto.comment.CommentUpdateRequestDto;
import com.team.project.Entity.Comment.Comment;
import com.team.project.Entity.Gallery.GalleryEntity;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Appl {

    @Id
    @Column(name = "acid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid")
    private GalleryEntity galleryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @Column
    private int sequence;

    @Lob
    private String content;

    @Column
    private String title;

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
    public Appl(GalleryEntity galleryEntity, User user, int sequence, String content, String title){
        this.galleryEntity = galleryEntity;
        this.user = user;
        this.sequence = sequence;
        this.content = content;
        this.title = title;
    }
}

