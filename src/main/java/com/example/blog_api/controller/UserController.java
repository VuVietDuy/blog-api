package com.example.blog_api.controller;

import com.example.blog_api.dto.UserDto;
import com.example.blog_api.entity.Roles;
import com.example.blog_api.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    //@RestController annotation is used combines the @Controller and @ResponseBody annotations. It's used to create
    //REST ful web services in Spring MVC app
    //@Controller annotation is used to indicate that a Java class defines a controller for handling HTTP requests in a
    //web application
    //@RestController annotation is used to indicate that the return value of a controller method should be treated as
    //the response body, rather than being resolved as a view name

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ResponseEntity is a class provided by the Spring Framework in Java for handling HTTP responses in a more flexible
    // and sophisticated manner

    //Controller không nên đụng tới data dạng domain model hoặc entity, chỉ được phép nhận và trả về DTO.

    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto resp = new UserDto(userId,"duy","duy", Roles.USER);
        return ResponseEntity.ok(resp);
    }
    //update user yourself
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(userDto);
    }

}
