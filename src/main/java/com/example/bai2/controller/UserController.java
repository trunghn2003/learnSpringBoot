package com.example.bai2.controller;

import com.example.bai2.dto.request.ApiResponse;
import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.dto.request.UserUpdateReQuest;
import com.example.bai2.dto.response.UserResponse;
import com.example.bai2.entity.User;
import com.example.bai2.service.UserService;
import jakarta.validation.Valid;
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
    ApiResponse<UserResponse> createUser(@Valid @RequestBody UserCreationRequest request) {
      ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
      apiResponse.setCode(200);
      apiResponse.setMessage("Success");
      apiResponse.setResult(userService.createUser(request));
      return apiResponse;
    }

    @GetMapping("")
    List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    UserResponse getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    UserResponse updateUser(@PathVariable String id, @RequestBody UserUpdateReQuest request) {
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
