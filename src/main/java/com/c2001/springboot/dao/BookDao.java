package com.c2001.springboot.dao;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book")
    List<Book> list();
    @Select("insert into book(name,description,price,category,author,publish_date)" +
            " values (#{name},#{description},#{price},#{category},#{author},#{publishDate})")
    void add(Book obj);
    @Select("select * from book where id = #{id}")
    Book getById(Integer id);
    @Select("update book set name = #{name},description = #{description}," +
            "price = #{price},category = #{category},author = #{author},publish_date=#{publishDate},status=#{status} where id = #{id}")
    void update(Book obj);
    @Select("delete from book where id = #{id} ")
    void deleteById(Integer id);
    @Select("<script>" +
            "select * from book"+
            "<where>"+
            "<if test=\"name != null and name != ''\">"+
            "name like concat('%', #{ name }, '%')"+
            "</if>"+
            "<if test=\"author != null and author != ''\">"+
            "and author like concat('%', #{ author }, '%')"+
            "</if>"+
            "<if test=\"category != null and category != ''\">"+
            "and category like concat('%', #{ category }, '%')"+
            "</if>"+
            "</where>"+
            "</script>")
    List<Book> listByCondition(BaseRequest baseRequest);

    @Select("select * from book where name = #{name}")
    Book getByName(String name);
}
