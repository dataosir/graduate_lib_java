package com.c2001.springboot.domain;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String email;

}
