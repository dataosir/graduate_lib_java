package com.c2001.springboot.controller.request;

import lombok.Data;

@Data
public class BookPageRequest extends BaseRequest{
    private String name;
    private String author;
    private String category;
}
