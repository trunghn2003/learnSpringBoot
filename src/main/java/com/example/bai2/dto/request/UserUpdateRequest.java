package com.example.bai2.dto.request;

import com.example.bai2.validator.DobContraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String firstName;
    String lastName;
    @DobContraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;
    List<String> roles;
}
