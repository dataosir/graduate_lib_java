package com.c2001.springboot.domain;


import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer id;
    private Integer status;
    private String name;
    private String description;
    private Integer price;
    private String author;
    private String category;
    private String publishDate;
}
