package com.c2001.springboot.service;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.domain.Borrow;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBorrowService {


    List<Borrow> getList() ;

    PageInfo<Borrow> getPage(BaseRequest baseRequest);

    void add(Borrow obj);

    Borrow getById(Integer id);

    void update(Borrow obj);

    void delete(Integer id);

}
