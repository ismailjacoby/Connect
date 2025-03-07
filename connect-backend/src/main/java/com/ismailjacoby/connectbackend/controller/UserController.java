package com.ismailjacoby.connectbackend.controller;

import com.ismailjacoby.connectbackend.dto.AuthDTO;
import com.ismailjacoby.connectbackend.form.LoginForm;
import com.ismailjacoby.connectbackend.form.SignupForm;
import com.ismailjacoby.connectbackend.service.declaration.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody @Valid LoginForm form){
        return userService.login(form);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignupForm form){
        userService.signup(form);
        return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created.");
    }
}
