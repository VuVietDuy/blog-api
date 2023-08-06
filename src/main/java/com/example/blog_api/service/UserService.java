package com.example.blog_api.service;

import com.example.blog_api.dto.ChangePasswordDto;
import com.example.blog_api.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {

    //The @Service annotation is used to mark a class as a service component.

    UserDto getUserById(Long userId);

    UserDto updateUser(UserDto userDto, Long userId, String name);;

    void deleteUser(Long userId);

    void changePassword(ChangePasswordDto changePasswordDto, String name);
}
