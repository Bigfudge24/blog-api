package com.blog.blogappapi.service;

import java.util.List;

import com.blog.blogappapi.payloads.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
    UserDto registerNewUser(UserDto userDto);
}
