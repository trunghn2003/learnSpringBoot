package com.example.bai2.dto.request;

import com.example.bai2.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data   // Lombok annotation to generate all the boilerplate code
@NoArgsConstructor
    @AllArgsConstructor
@Builder
public class UserCreationRequest {
    @Size(min = 6, message = "USERNAME_INVALID")
    private  String username;
    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;
    private String fristName;
    private String lastName;
    private LocalDate dob;


}
