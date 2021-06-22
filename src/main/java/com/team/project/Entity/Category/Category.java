package com.team.project.Entity.Category;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String picture1;

    @Column(nullable = false)
    private String picture2;


    @Column(nullable = false)
    private String picture3;

    @Column(nullable = false)
    private String picture4;

    @Column(nullable = false)
    private String picture5;


    @Builder
    public Category(Long id, String name, String picture1, String picture2, String picture3, String picture4, String picture5) {
        this.id = id;
        this.name = name;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.picture4 = picture4;
        this.picture5 = picture5;
    }
}
