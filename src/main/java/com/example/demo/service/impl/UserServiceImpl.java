UserServiceImpl.java

package com.example.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepo,
                           BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {

        // default role
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        // encrypt password
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }
}