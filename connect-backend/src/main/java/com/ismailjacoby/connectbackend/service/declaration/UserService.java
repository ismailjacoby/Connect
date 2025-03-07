package com.ismailjacoby.connectbackend.service.declaration;

import com.ismailjacoby.connectbackend.dto.AuthDTO;
import com.ismailjacoby.connectbackend.form.LoginForm;
import com.ismailjacoby.connectbackend.form.SignupForm;

public interface UserService {
    AuthDTO login(LoginForm form);
    void signup(SignupForm form);
}
