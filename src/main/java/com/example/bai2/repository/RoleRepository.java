package com.example.bai2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bai2.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
