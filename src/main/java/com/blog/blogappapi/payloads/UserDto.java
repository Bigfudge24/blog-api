package com.blog.blogappapi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
    private int uId;
    @NotEmpty
    @Size(min = 4,message = "Username must have more than 4 characters")
    private String name;
    @Email(message = "Email address is not valid")
    @NotBlank
    private String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "Password must be between 3 to 10 characters")
    private String password;
    @NotEmpty
    @Size(min = 10,max = 500,message = "About should be between 10 to 500 characters")
    private String about;
    public UserDto() {
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
