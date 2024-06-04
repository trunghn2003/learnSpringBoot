package com.example.bai2.mapper;

import com.example.bai2.dto.request.PermissionRequest;
import com.example.bai2.dto.response.PermissionResponse;
import com.example.bai2.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
