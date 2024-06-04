package com.example.bai2.dto.request;


import jakarta.validation.constraints.Negative;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateReQuest {
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    List<String> roles;
}
