package com.dev.fitbooking.controller;

import com.dev.fitbooking.dto.response.UserResponseDto;
import com.dev.fitbooking.service.UserService;
import com.dev.fitbooking.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userMapper.toDto(userService.findByEmail(email).orElseThrow(()
                -> new RuntimeException("Can not get user with email: " + email)));
    }
}
