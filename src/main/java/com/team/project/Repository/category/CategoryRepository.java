package com.team.project.Repository.category;

import com.team.project.Entity.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
