package com.ismailjacoby.connectbackend.service.declaration;

import com.ismailjacoby.connectbackend.form.PostTextForm;

public interface PostService {

    // Text Posts
    void createTextPost(PostTextForm form, String username);
}
