package com.blog.blogappapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();
    
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
