package com.ismailjacoby.connectbackend.service.implementation;

import com.ismailjacoby.connectbackend.exception.NotFoundException;
import com.ismailjacoby.connectbackend.form.PostTextForm;
import com.ismailjacoby.connectbackend.model.entity.PostEntity;
import com.ismailjacoby.connectbackend.model.entity.UserEntity;
import com.ismailjacoby.connectbackend.model.enums.PostType;
import com.ismailjacoby.connectbackend.repository.PostRepository;
import com.ismailjacoby.connectbackend.repository.UserRepository;
import com.ismailjacoby.connectbackend.service.declaration.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTextPost(PostTextForm form, String username) {

        if(form == null) {
            throw new IllegalArgumentException("Form cannot be null");
        }

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));


        PostEntity post = new PostEntity();
        post.setType(PostType.TEXT);
        post.setText(form.text());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setArchived(false);
        post.setViews(0L);
        post.setUser(user);
        postRepository.save(post);
    }
}
