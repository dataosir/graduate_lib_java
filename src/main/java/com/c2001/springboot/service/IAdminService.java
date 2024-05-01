package com.c2001.springboot.service;

import com.c2001.springboot.controller.dto.LoginDTO;
import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.domain.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {


    List<Admin> getAllAdmin() ;
    PageInfo<Admin> getPage(BaseRequest baseRequest);

    void addAdmin(Admin admin);

    Admin getById(Integer id);

    void update(Admin admin);

    void deleteAdmin(Integer id);

    LoginDTO login(LoginRequest loginRequest);
}
