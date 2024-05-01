package com.c2001.springboot.controller;

import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.dto.LoginDTO;
import com.c2001.springboot.controller.request.AdminPageRequest;
import com.c2001.springboot.controller.request.BookPageRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.domain.Book;
import com.c2001.springboot.service.IAdminService;
import com.c2001.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //解决跨域
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/list")
    public Result getList(){
    List<Book> books =bookService.getList();
        return Result.success(books);
    }
    @GetMapping("/page")
    public Result getPage(BookPageRequest bookPageRequest){
        return Result.success(bookService.getPage(bookPageRequest));
    }
    @PostMapping
    public Result add(@RequestBody Book book){
        bookService.add(book);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        return Result.success(book);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Book book){
        bookService.update(book);
        return Result.success();
    }
    @PutMapping("/change/{id}")
    public Result change(@PathVariable Integer id){
        bookService.changeStatus(id);
        return Result.success();
    }
    @PutMapping("/changeByName/{name}")
    public Result changeByName(@PathVariable String name){
        bookService.changeStatusByName(name);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        bookService.delete(id);
        return Result.success();
    }
}
