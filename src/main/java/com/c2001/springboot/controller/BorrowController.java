package com.c2001.springboot.controller;

import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.request.BorrowPageRequest;
import com.c2001.springboot.domain.Borrow;
import com.c2001.springboot.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //解决跨域
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    IBorrowService borrowService;

    @GetMapping("/list")
    public Result getList(){
    List<Borrow> books =borrowService.getList();
        return Result.success(books);
    }
    @GetMapping("/page")
    public Result getPage(BorrowPageRequest borrowPageRequest){
        return Result.success(borrowService.getPage(borrowPageRequest));
    }
    @PostMapping
    public Result add(@RequestBody Borrow borrow){
        borrowService.add(borrow);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Borrow borrow = borrowService.getById(id);
        return Result.success(borrow);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Borrow borrow){
        borrowService.update(borrow);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        borrowService.delete(id);
        return Result.success();
    }
}
