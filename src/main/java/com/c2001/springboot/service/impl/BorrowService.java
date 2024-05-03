package com.c2001.springboot.service.impl;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.dao.BorrowDao;
import com.c2001.springboot.domain.Borrow;
import com.c2001.springboot.service.IBookService;
import com.c2001.springboot.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    BorrowDao borrowDao;

    @Override
    public List<Borrow> getList() {
        return borrowDao.list();
    }

    public PageInfo<Borrow> getPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Borrow> borrows = borrowDao.listByCondition(baseRequest);
        borrows.forEach(e->{
            e.setBuyedStr("否");
            if (Objects.equals(1,e.getBuyed())){
                e.setBuyedStr("是");
            }
        });
        return new PageInfo<>(borrows);
    }

    public void add(Borrow book) {
        //自动生成username,唯一
        borrowDao.add(book);
        return;
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowDao.getById(id);
    }

    @Override
    public void update(Borrow book) {

        borrowDao.update(book);
    }

    @Override
    public void delete(Integer id) {
        borrowDao.deleteById(id);
        return;
    }


}
