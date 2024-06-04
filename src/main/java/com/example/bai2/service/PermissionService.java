package com.example.bai2.service;

import com.example.bai2.dto.request.PermissionRequest;
import com.example.bai2.dto.response.PermissionResponse;
import com.example.bai2.entity.Permission;
import com.example.bai2.mapper.PermissonMapper;
import com.example.bai2.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissonMapper permissonMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissonMapper.toPermisson(request);
        permissionRepository.save(permission);
        return permissonMapper.toPermissonResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(
                permissonMapper::toPermissonResponse
        ).toList();

    }

    public void delete(String name) {
        permissionRepository.deleteById(name);

    }
}
