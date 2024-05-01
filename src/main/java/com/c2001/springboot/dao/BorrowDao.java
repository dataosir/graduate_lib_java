package com.c2001.springboot.dao;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.domain.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowDao {
    @Select("select * from borrow")
    List<Borrow> list();
    @Select("insert into borrow(name,author,price,stunumber,stuname)" +
            " values (#{name},#{author},#{price},#{stunumber},#{stuname})")
    void add(Borrow obj);
    @Select("select * from borrow where id = #{id}")
    Borrow getById(Integer id);
    @Select("update borrow set name = #{name},author = #{author}," +
            "price = #{price},stunumber = #{stunumber},stuname = #{stuname} where id = #{id}")
    void update(Borrow obj);
    @Select("delete from borrow where id = #{id} ")
    void deleteById(Integer id);
    @Select("<script>" +
            "select * from borrow"+
            "<where>"+
            "<if test=\"name != null and name != ''\">"+
            "name like concat('%', #{ name }, '%')"+
            "</if>"+
            "<if test=\"stuname != null and stuname != ''\">"+
            "and stuname like concat('%', #{ stuname }, '%')"+
            "</if>"+
            "<if test=\"stunumber != null and stunumber != ''\">"+
            "and stunumber like concat('%', #{ stunumber }, '%')"+
            "</if>"+
            "</where>"+
            "</script>")
    List<Borrow> listByCondition(BaseRequest baseRequest);
}
