package com.c2001.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.dao.CategoryDao;
import com.c2001.springboot.dao.UserDao;
import com.c2001.springboot.domain.Category;
import com.c2001.springboot.domain.Category;
import com.c2001.springboot.service.ICategoryService;
import com.c2001.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getList() {
        return categoryDao.list();
    }

    public PageInfo<Category> getPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Category> users = categoryDao.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }

    public void add(Category category) {
        //自动生成username,唯一
        categoryDao.add(category);
        return;
    }

    @Override
    public Category getById(Integer id) {
        return categoryDao.getById(id);
    }

    @Override
    public void update(Category category) {

        categoryDao.update(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.deleteById(id);
        return;
    }


}
