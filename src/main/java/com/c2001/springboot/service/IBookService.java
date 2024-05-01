package com.c2001.springboot.service;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.domain.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {


    List<Book> getList() ;

    PageInfo<Book> getPage(BaseRequest baseRequest);

    void add(Book obj);

    Book getById(Integer id);

    void update(Book obj);

    void delete(Integer id);

    void changeStatus(Integer id);

    void changeStatusByName(String name);
}
