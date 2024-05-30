package com.example.bai2.controller;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.entity.User;
import com.example.bai2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserCreationRequest request) {
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
