package com.example.bai2.service;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.entity.User;
import com.example.bai2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(UserCreationRequest request) {
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFristName(request.getFristName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserCreationRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFristName(request.getFristName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
