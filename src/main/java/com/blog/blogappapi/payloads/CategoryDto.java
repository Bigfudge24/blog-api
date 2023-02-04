package com.blog.blogappapi.payloads;

public class CategoryDto {
    private int categoryId;
    private String categoryTitle;
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
