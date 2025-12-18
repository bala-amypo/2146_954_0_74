package com.example.demo.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public UserEntity registerUser(UserEntity user) {
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}