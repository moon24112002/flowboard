package com.flowboard_service.controller;

import com.flowboard_service.models.User;
import com.flowboard_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository _userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        _userRepository.save(user);
        return ResponseEntity.ok(user);
    }

}
