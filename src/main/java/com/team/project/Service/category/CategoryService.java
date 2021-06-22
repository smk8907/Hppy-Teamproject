package com.team.project.Service.category;

import com.team.project.Dto.category.CategoryResponseDto;
import com.team.project.Entity.Category.Category;
import com.team.project.Repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Transactional
    public Page<Category> getCategoryList(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public CategoryResponseDto findById(long id){
        Category entity = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id= " + id));

        return new CategoryResponseDto(entity);
    }
}
