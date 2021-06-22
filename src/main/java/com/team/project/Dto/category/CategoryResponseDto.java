package com.team.project.Dto.category;

import com.team.project.Entity.Category.Category;

public class CategoryResponseDto {

    private Long id;
    private String name;
    private String picture1;
    private String picture2;
    private String picture3;
    private String picture4;
    private String picture5;

    public CategoryResponseDto(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.picture1 = entity.getPicture1();
        this.picture2 = entity.getPicture2();
        this.picture3 = entity.getPicture3();
        this.picture4 = entity.getPicture4();
        this.picture5 = entity.getPicture5();

    }
}