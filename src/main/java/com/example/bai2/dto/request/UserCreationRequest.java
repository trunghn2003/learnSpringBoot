package com.example.bai2.dto.request;

import com.example.bai2.exception.ErrorCode;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {
    @Size(min = 6, message = "USERNAME_INVALID")
    private  String username;
    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;
    private String fristName;
    private String lastName;
    private LocalDate dob;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
