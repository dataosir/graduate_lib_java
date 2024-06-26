package com.c2001.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.UserBorrowRequest;
import com.c2001.springboot.dao.UserDao;
import com.c2001.springboot.domain.User;
import com.c2001.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    UserDao userdao;

    @Override
    public List<User> getAllUser() {
        return userdao.listUsers();
    }

    public PageInfo<User> getPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<User> users = userdao.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    public void addUser(User user) {
        //自动生成username,唯一
        user.setUsername(DateUtil.format(new Date(),"yyyyMMdd")+IdUtil.fastSimpleUUID());
        userdao.addUser(user);
        return;
    }

    @Override
    public User getById(Integer id) {
        return userdao.getById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdatetime(new Date());
        userdao.update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userdao.deleteById(id);
        return;
    }

    @Override
    public Boolean borrowBookByUser(UserBorrowRequest userBorrowRequest) {
        User user = userdao.borrowBookByUser(userBorrowRequest.getStuname(),userBorrowRequest.getStunumber());
        if(user == null)
            return false;
        else {
            return true;
        }
    }


}
