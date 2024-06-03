package com.example.bai2.service;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.dto.request.UserUpdateReQuest;
import com.example.bai2.dto.response.UserResponse;
import com.example.bai2.entity.User;
import com.example.bai2.exception.AppException;
import com.example.bai2.exception.ErrorCode;
import com.example.bai2.mapper.UserMapper;
import com.example.bai2.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    public UserResponse createUser(UserCreationRequest request) {
//        User user = new User();
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXITS);
        }
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return   userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {

        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUserById(String id) {
        
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateReQuest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
