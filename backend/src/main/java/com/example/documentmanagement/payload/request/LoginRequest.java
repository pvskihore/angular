package com.example.documentmanagement.payload.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
