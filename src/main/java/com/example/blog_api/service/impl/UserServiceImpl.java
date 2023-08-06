package com.example.blog_api.service.impl;

import com.example.blog_api.dto.ChangePasswordDto;
import com.example.blog_api.dto.UserDto;
import com.example.blog_api.entity.User;
import com.example.blog_api.exception.BlogAPIException;
import org.modelmapper.ModelMapper;
import com.example.blog_api.repository.UserRepository;
import com.example.blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BlogAPIException(HttpStatus.BAD_REQUEST, "User not found"));
        return mapToDTO(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId, String name) {
        User user = userRepository.findById(userId).orElseThrow(() -> new BlogAPIException(HttpStatus.BAD_REQUEST, "User not found"));
        if(user.getUsername().equals(name)) {
            throw new BlogAPIException(HttpStatus.UNAUTHORIZED, "You are not authorized to update this user");
        }

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user = userRepository.save(user);

        return mapToDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new BlogAPIException(HttpStatus.NOT_FOUND, "User not found"));
        if (!passwordEncoder.matches(changePasswordDto.getOldPassword(), user.getPassword())) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Old password is not correct");
        }

        user.setPassword(changePasswordDto.getNewPassword());
        userRepository.save(user);
    }

    private User mapToEntity(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

    private UserDto mapToDTO(User user) {
        return mapper.map(user, UserDto.class);
    }
}
