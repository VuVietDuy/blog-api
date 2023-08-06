package com.example.blog_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}
