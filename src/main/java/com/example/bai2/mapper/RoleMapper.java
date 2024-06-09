package com.example.bai2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.bai2.dto.request.RoleRequest;
import com.example.bai2.dto.response.RoleResponse;
import com.example.bai2.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
