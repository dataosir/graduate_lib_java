package com.c2001.springboot.service.impl;


import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.dto.LoginDTO;
import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.dao.AdminDao;
import com.c2001.springboot.domain.Admin;
import com.c2001.springboot.exception.ServiceException;
import com.c2001.springboot.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
@Slf4j
@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminDao admindao;

    @Override
    public List<Admin> getAllAdmin() {
        return admindao.listAdmins();
    }

    public PageInfo<Admin> getPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Admin> admins = admindao.listByCondition(baseRequest);
        return new PageInfo<>(admins);
    }

    public void addAdmin(Admin admin) {
        //自动生成username,唯一
//        admin.setUsername(DateUtil.format(new Date(),"yyyyMMdd")+IdUtil.fastSimpleUUID());

        admindao.addAdmin(admin);
        return;
    }

    @Override
    public Admin getById(Integer id) {
        return admindao.getById(id);
    }

    @Override
    public void update(Admin admin) {
        admindao.update(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        admindao.deleteById(id);
        return;
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        Admin admin = admindao.getByUsernameAndPassword(loginRequest);
        if(admin==null){
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin,loginDTO);
        return loginDTO;

    }


}
