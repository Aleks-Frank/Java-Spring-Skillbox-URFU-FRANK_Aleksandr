package com.example.posts_app_new.repository;

import com.example.posts_app_new.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
