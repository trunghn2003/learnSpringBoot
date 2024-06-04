package com.example.bai2.dto.response;

import com.example.bai2.entity.Role;
import com.example.bai2.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
     String id;
     String username;
     String firstName; // Corrected the typo from "fristName" to "firstName"
     String lastName;
     LocalDate dob;
     Set<RoleResponse> roles;
}
