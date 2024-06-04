package com.example.bai2.mapper;

import com.example.bai2.dto.request.PermissionRequest;
import com.example.bai2.dto.request.RoleRequest;
import com.example.bai2.dto.response.PermissionResponse;
import com.example.bai2.dto.response.RoleResponse;
import com.example.bai2.entity.Permission;
import com.example.bai2.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    @Mapping(target = "permissions", ignore = true)
    RoleResponse toRoleResponse(Role role);
}
