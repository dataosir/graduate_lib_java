package com.c2001.springboot.controller.request;

import lombok.Data;

@Data
public class BorrowPageRequest extends BaseRequest{
    private String name;
    private String stuname;
    private String stunumber;
}
