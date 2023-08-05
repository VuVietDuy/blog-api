package com.example.blog_api.service;

import com.example.blog_api.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {

    //The @Service annotation is used to mark a class as a service component.
    UserDto getUser(Long userId);
}
