package com.example.bai2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.bai2.dto.request.UserCreationRequest;
import com.example.bai2.dto.request.UserUpdateRequest;
import com.example.bai2.dto.response.UserResponse;
import com.example.bai2.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
