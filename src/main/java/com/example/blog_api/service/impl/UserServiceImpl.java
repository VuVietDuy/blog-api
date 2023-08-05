package com.example.blog_api.service.impl;

import com.example.blog_api.dto.UserDto;
import com.example.blog_api.entity.User;
import org.modelmapper.ModelMapper;
import com.example.blog_api.repository.UserRepository;
import com.example.blog_api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return mapToDTO(user);
    }

    private User mapToEntity(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

    private UserDto mapToDTO(User user) {
        return mapper.map(user, UserDto.class);
    }
}
