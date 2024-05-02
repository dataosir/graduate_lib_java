package com.c2001.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private String sex;
    private Long money;
    private String stunumber;//学号
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date updatetime;
}
