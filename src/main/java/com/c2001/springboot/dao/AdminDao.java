package com.c2001.springboot.dao;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.domain.Admin;
import com.c2001.springboot.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDao {
    @Select("select * from admin")
    List<Admin> listAdmins();
    @Select("<script>" +
            "select * from admin"+
            "<where>"+
            "<if test=\"username != null and username != ''\">"+
            "username like concat('%', #{ username }, '%')"+
            "</if>"+
            "<if test=\"email != null and email != ''\">"+
            "and email like concat('%', #{ email }, '%')"+
            "</if>"+
            "</where>"+
            "</script>")
    List<Admin> listByCondition(BaseRequest baseRequest);
    @Select("insert into Admin(password,username,email)" +
            " values (#{password},#{username},#{email})")
    void addAdmin(Admin admin);
    @Select("select * from Admin where id = #{id}")
    Admin getById(Integer id);
    @Select("update admin set username = #{username},email = #{email},password = #{password} where id = #{id}")
    void update(Admin admin);
    @Select("delete from Admin where id = #{id}")
    void deleteById(Integer id);
    @Select("select * from Admin where username = #{username} and password = #{password}")
    Admin getByUsernameAndPassword(LoginRequest loginRequest);
}
