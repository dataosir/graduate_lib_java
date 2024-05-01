package com.c2001.springboot.controller;

import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.dto.LoginDTO;
import com.c2001.springboot.controller.request.AdminPageRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.controller.request.UserPageRequest;
import com.c2001.springboot.domain.Admin;
import com.c2001.springboot.domain.Admin;
import com.c2001.springboot.service.IAdminService;
import com.c2001.springboot.service.impl.AdminService;
import com.c2001.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //解决跨域
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO loginDTO = adminService.login(loginRequest);
        return Result.success(loginDTO);
    }
    @GetMapping("/list")
    public Result getAllAdmins(){
    List<Admin> admins =adminService.getAllAdmin();
        return Result.success(admins);
    }
    @GetMapping("/page")
    public Result getAdminsPage(AdminPageRequest adminPageRequest){
        return Result.success(adminService.getPage(adminPageRequest));
    }
    @PostMapping
    public Result addAdmin(@RequestBody Admin admin){
        adminService.addAdmin(admin);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }
    @PutMapping("/update")
    public Result updateAdmin(@RequestBody Admin admin){
        adminService.update(admin);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteAdmin(@PathVariable Integer id){
        adminService.deleteAdmin(id);
        return Result.success();
    }
}
