package com.c2001.springboot.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
