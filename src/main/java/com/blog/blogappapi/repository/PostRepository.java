package com.blog.blogappapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogappapi.entity.Category;
import com.blog.blogappapi.entity.Post;
import com.blog.blogappapi.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	
}
