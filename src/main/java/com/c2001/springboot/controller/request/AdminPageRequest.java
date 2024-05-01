package com.c2001.springboot.controller.request;

import lombok.Data;

@Data
public class AdminPageRequest extends BaseRequest{
    private String password;
    private String username;
    private String email;

}
