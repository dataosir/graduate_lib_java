package com.c2001.springboot.service;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.domain.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICategoryService {


    List<Category> getList() ;

    PageInfo<Category> getPage(BaseRequest baseRequest);

    void add(Category obj);

    Category getById(Integer id);

    void update(Category obj);

    void delete(Integer id);

}
