package com.c2001.springboot.dao;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.domain.Admin;
import com.c2001.springboot.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryDao {
    @Select("select * from category")
    List<Category> list();
    @Select("insert into category(name,remark,pid)" +
            " values (#{name},#{remark},#{pid})")
    void add(Category obj);
    @Select("select * from category where id = #{id}")
    Category getById(Integer id);
    @Select("update category set name = #{name},remark = #{remark} where id = #{id}")
    void update(Category obj);
    @Select("delete from category where id = #{id} ")
    void deleteById(Integer id);

    void selectByPid(Integer pid);

    List<Category> listByCondition(BaseRequest baseRequest);
}
