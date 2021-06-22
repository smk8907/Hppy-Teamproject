package com.team.project.Entity.Board;


import com.team.project.Entity.BaseTimeEntity;
import com.team.project.Entity.User.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class Mentor extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mid")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column
    private String htype;

    @Column
    private int career;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @Builder
    public Mentor(String title, String content, String htype, User user, int career) {
        this.title = title;
        this.content = content;
        this.htype = htype;
        this.user = user;
        this.career = career;
    }

    public void update(String title, String content, String htype, int career) {
        this.title = title;
        this.content = content;
        this.htype = htype;
        this.career = career;
    }
}
