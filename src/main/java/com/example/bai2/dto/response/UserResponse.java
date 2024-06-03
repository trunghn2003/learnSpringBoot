package com.example.bai2.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
     String id;
     String username;
     String password;
     String fristName;
     String lastName;
     LocalDate dob;
}
