package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity userRequest) {
        UserEntity user = userService.findByUsername(userRequest.getUsername());
        if (user != null && user.getPassword().equals(userRequest.getPassword())) {
            // JWT token fix: pass id, username, role
            String token = jwtUtil.generateToken(user.getId(), user.getUsername(), user.getRole());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        // Use username instead of email if email not present
        if (user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }
        user.setRole("USER");
        UserEntity savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
