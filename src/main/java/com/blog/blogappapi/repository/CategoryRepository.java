package com.blog.blogappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogappapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
