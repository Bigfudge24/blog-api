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

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    @Column(name = "user_name",nullable = false,length = 100)
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_about")
    private String about;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();
    
    
    public User() {
    }
    public int getuId() {
        return uId;
    }
    public void setuId(int uId) {
        this.uId = uId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    
}
