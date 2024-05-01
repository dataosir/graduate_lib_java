package com.c2001.springboot.dao;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.UserPageRequest;
import com.c2001.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> listUsers();
    @Select("<script>" +
            "select * from user"+
            "<where>"+
            "<if test=\"name != null and name != ''\">"+
            "name like concat('%', #{ name }, '%')"+
            "</if>"+
            "<if test=\"stunumber != null and stunumber != ''\">"+
            "and stunumber like concat('%', #{ stunumber }, '%')"+
            "</if>"+
            "</where>"+
//            "order by id desc"+
            "</script>")
    List<User> listByCondition(BaseRequest baseRequest);
    @Select("insert into user(name,username,age,sex,stunumber)" +
            " values (#{name},#{username},#{age},#{sex},#{stunumber})")
    void addUser(User user);
    @Select("select * from user where id = #{id}")
    User getById(Integer id);
    @Select("update user set name = #{name},age = #{age},sex = #{sex},stunumber = #{stunumber},updatetime = #{updatetime} where id = #{id}")
    void update(User user);
    @Select("delete from user where id = #{id}")
    void deleteById(Integer id);
    @Select("select * from user where name = #{stuname} and stunumber = #{stunumber}")
    User borrowBookByUser(String stuname, String stunumber);
}
