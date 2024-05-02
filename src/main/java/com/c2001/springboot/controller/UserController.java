package com.c2001.springboot.controller;

import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.request.UserBorrowRequest;
import com.c2001.springboot.controller.request.UserPageRequest;
import com.c2001.springboot.domain.User;
import com.c2001.springboot.service.IUserService;
import com.c2001.springboot.service.impl.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin    //解决跨域
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/list")
    public Result getAllUsers(){
    List<User> users =userService.getAllUser();
        return Result.success(users);
    }
    @PostMapping("/borrow")
    public Result borrowBookByUser(@RequestBody UserBorrowRequest userBorrowRequest){
        Boolean aBoolean =userService.borrowBookByUser(userBorrowRequest);
        if(aBoolean){
            return Result.success(aBoolean);
        }
         return Result.error("学生信息出错");
    }
    @PostMapping("/buying")
    public Result buying(@RequestBody UserBorrowRequest userBorrowRequest)  {
        Boolean aBoolean =userService.buying(userBorrowRequest);
        if(aBoolean){
            return Result.success(aBoolean);
        }
        return Result.error("学生信息出错");
    }
    @GetMapping("/page")
    public Result getUsersPage(UserPageRequest userPageRequest){
        return Result.success(userService.getPage(userPageRequest));
    }
    @PostMapping
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result updateUser(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.success();
    }
}
