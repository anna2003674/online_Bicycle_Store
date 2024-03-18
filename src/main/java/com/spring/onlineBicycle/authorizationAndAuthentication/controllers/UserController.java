package com.spring.onlineBicycle.authorizationAndAuthentication.controllers;


import com.spring.onlineBicycle.authorizationAndAuthentication.models.MyUser;
import com.spring.onlineBicycle.authorizationAndAuthentication.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody MyUser user) {
        userService.saveUser(user);
        return "User registered successfully!";
    }
}