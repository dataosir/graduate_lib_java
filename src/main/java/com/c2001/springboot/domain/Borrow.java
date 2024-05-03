package com.c2001.springboot.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private Integer id;
    private String name;
    private String author;
    private Integer price;
    private String stunumber;
    private String stuname;
    private Integer buyed;
    private String buyedStr;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date createtime;
}
