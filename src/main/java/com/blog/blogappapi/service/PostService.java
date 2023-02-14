package com.blog.blogappapi.service;

import java.util.List;

import com.blog.blogappapi.entity.Post;
import com.blog.blogappapi.payloads.PostDto;

public interface PostService {
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	PostDto updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllPost();
	PostDto getPostById(Integer postId);
	List<PostDto> getPostByCategory(Integer catergoryId);
	List<PostDto> getPostByUser(Integer userId);
	List<Post> searchPosts(String keyword);
}
