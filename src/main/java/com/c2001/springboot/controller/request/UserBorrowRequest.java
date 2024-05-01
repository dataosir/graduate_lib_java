package com.c2001.springboot.controller.request;

import lombok.Data;

@Data
public class UserBorrowRequest {
    private String stuname;
    private String stunumber;
}
