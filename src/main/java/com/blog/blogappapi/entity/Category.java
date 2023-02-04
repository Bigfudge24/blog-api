package com.blog.blogappapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    @Column(name = "title")
    private String categoryTitle;
    @Column(name = "description")
    private String catgoryDescription;
    public Category() {
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryTitle() {
        return categoryTitle;
    }
    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
    public String getCatgoryDescription() {
        return catgoryDescription;
    }
    public void setCatgoryDescription(String catgoryDescription) {
        this.catgoryDescription = catgoryDescription;
    }

    
}
