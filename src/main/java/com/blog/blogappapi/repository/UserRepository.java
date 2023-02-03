package com.blog.blogappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogappapi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
