package com.example.blog_api.dto;

import com.example.blog_api.entity.Roles;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    // DTO(Data Transfer Object) is an object that carries data between processes. When working with a remote interface,
    // each call is expensive. As a result, you need to reduce the number of calls. The solution is to create a dto that
    // can hold all the data for the call

    private Long id;

    private String username;

    private String password;

    private Roles roles;
}
