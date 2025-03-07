package com.ismailjacoby.connectbackend.service.implementation;

import com.ismailjacoby.connectbackend.config.security.JWTProvider;
import com.ismailjacoby.connectbackend.dto.AuthDTO;
import com.ismailjacoby.connectbackend.exception.DuplicateResourceException;
import com.ismailjacoby.connectbackend.form.LoginForm;
import com.ismailjacoby.connectbackend.form.SignupForm;
import com.ismailjacoby.connectbackend.model.entity.UserEntity;
import com.ismailjacoby.connectbackend.model.enums.UserRole;
import com.ismailjacoby.connectbackend.model.enums.UserStatus;
import com.ismailjacoby.connectbackend.repository.UserRepository;
import com.ismailjacoby.connectbackend.service.declaration.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private JWTProvider jwtProvider;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,JWTProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public AuthDTO login(LoginForm form) {
        if (form == null) {
            throw new IllegalArgumentException("Login form cannot be null");
        }

        String userInput = form.usernameOrEmail();
        Optional<UserEntity> userOptional;

        if (userInput.contains("@")) {
            userOptional = userRepository.findByEmail(userInput);
        } else {
            userOptional = userRepository.findByUsername(userInput);
        }

        UserEntity user = userOptional
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password1"));

        if (!passwordEncoder.matches(form.password(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        String token = jwtProvider.generateToken(user.getUsername(), user.getRole());
        user.setLastLogin(LocalDate.now());
        userRepository.save(user);

        return new AuthDTO(user.getUsername(), token, user.getRole());
    }

    @Override
    public void signup(SignupForm form) {
        if(form == null) {
            throw new IllegalArgumentException("Signup form cannot be null.");
        }

        if(userRepository.existsByUsername(form.username())){
            throw new DuplicateResourceException("Username is already taken.");
        }

        if(userRepository.existsByEmail(form.email())){
            throw new DuplicateResourceException("Email is already taken.");
        }

        UserEntity user = new UserEntity();
        user.setUsername(form.username());
        user.setPassword(passwordEncoder.encode(form.password()));
        user.setFirstName(form.firstName());
        user.setLastName(form.lastName());
        user.setEmail(form.email());
        user.setBirthDate(form.birthDate());
        user.setRole(UserRole.USER);
        user.setStatus(UserStatus.ACTIVE);
        user.setPrivateAccount(false);
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        user.setDeleted(false);

        userRepository.save(user);
    }


}
