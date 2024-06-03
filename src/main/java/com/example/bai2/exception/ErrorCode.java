package com.example.bai2.exception;

public enum ErrorCode{
   INVALID_KEY(1, "Invalid key"),
    UNCAUGHT_EXCEPTION (9999, "Uncaught exception"),
    USER_EXITS (1001, "User exits"),
    USERNAME_INVALID (1002, "Username must be at least 3 characters"),
    PASSWORD_INVALID (1003, "Password must be at least 6 characters")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private  int code;
    private  String message;
}
