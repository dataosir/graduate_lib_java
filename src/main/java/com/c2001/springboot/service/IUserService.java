package com.c2001.springboot.service;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.UserBorrowRequest;
import com.c2001.springboot.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {


    List<User> getAllUser() ;
    PageInfo<User> getPage(BaseRequest baseRequest);

    void addUser(User user);

   User getById(Integer id);

    void update(User user);

    void deleteUser(Integer id);

    Boolean borrowBookByUser(UserBorrowRequest userBorrowRequest);

    Boolean buying(UserBorrowRequest userBorrowRequest) throws Exception;
}
