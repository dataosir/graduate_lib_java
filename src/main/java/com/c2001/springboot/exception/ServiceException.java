package com.c2001.springboot.exception;
//定义业务错误异常
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
