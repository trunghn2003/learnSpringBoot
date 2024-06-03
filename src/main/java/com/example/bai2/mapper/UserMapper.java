package com.example.bai2.mapper;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.dto.request.UserUpdateReQuest;
import com.example.bai2.dto.response.UserResponse;
import com.example.bai2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateReQuest request);
    UserResponse toUserResponse(User user);
}
