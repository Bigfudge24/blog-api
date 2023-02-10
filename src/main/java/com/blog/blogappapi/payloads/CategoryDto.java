package com.blog.blogappapi.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
    private int categoryId;
    @NotBlank
    @Size(min = 3,message = "Title should be more than 3 characters")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10,message = "Description should be more than 10 characters")
    private String catgoryDescription;
    public CategoryDto() {
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
