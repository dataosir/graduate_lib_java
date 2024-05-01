package com.c2001.springboot.service.impl;

import com.c2001.springboot.controller.request.BaseRequest;
import com.c2001.springboot.dao.BookDao;
import com.c2001.springboot.domain.Book;
import com.c2001.springboot.service.IBookService;
import com.c2001.springboot.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getList() {
        return bookDao.list();
    }

    public PageInfo<Book> getPage(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Book> books = bookDao.listByCondition(baseRequest);
        return new PageInfo<>(books);
    }

    public void add(Book book) {
        book.setStatus(0);
        bookDao.add(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public void update(Book book) {

        bookDao.update(book);
    }

    @Override
    public void delete(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public void changeStatus(Integer id) {
        Book book = bookDao.getById(id);
        book.setStatus(1- book.getStatus());
        bookDao.update(book);
    }

    @Override
    public void changeStatusByName(String name) {
        Book book = bookDao.getByName(name);
        book.setStatus(1- book.getStatus());
        bookDao.update(book);
    }


}
