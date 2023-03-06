package com.blog.blogappapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blogappapi.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
    
}
