package com.ismailjacoby.connectbackend.controller;

import com.ismailjacoby.connectbackend.exception.NotFoundException;
import com.ismailjacoby.connectbackend.form.PostTextForm;
import com.ismailjacoby.connectbackend.service.declaration.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Text
    @PostMapping("/text/create")
    public ResponseEntity<String> createTextPost(@RequestBody @Valid PostTextForm form, @AuthenticationPrincipal UserDetails user){
        if (user == null) {
            throw new NotFoundException("User not found");
        }

        postService.createTextPost(form, user.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created");
    }
}
