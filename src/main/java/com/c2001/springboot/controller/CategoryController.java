package com.c2001.springboot.controller;

import cn.hutool.core.collection.CollUtil;
import com.c2001.springboot.config.Result;
import com.c2001.springboot.controller.dto.LoginDTO;
import com.c2001.springboot.controller.request.AdminPageRequest;
import com.c2001.springboot.controller.request.CategoryPageRequest;
import com.c2001.springboot.controller.request.LoginRequest;
import com.c2001.springboot.domain.Category;
import com.c2001.springboot.service.IAdminService;
import com.c2001.springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin    //解决跨域
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public Result getList(){
    List<Category> obj =categoryService.getList();
        return Result.success(obj);
    }
    @GetMapping("/tree")
    public Result tree(){
        List<Category> list =categoryService.getList();
        Object obj = createTree(null,list);
        return Result.success(obj);   //第一级id为null
    }
    //递归查询子分类
    private List<Category> createTree(Integer pid, List<Category> categories) {
        List<Category> treeList = new ArrayList<>();
        for (Category category : categories) {
            if (pid == null) {
                if (category.getPid() == null) {  // 那这就是第一级节点
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            } else {
                if (pid.equals(category.getPid())) {
                    treeList.add(category);
                    if(category.getId()!=null)
                    category.setChildren(createTree(category.getId(), categories));
                }
            }
            if (CollUtil.isEmpty(category.getChildren())) {
                category.setChildren(null);
            }
        }
        return treeList;
    }
    @GetMapping("/page")
    public Result getPage(CategoryPageRequest categoryPageRequest){
        return Result.success(categoryService.getPage(categoryPageRequest));
    }
    @PostMapping
    public Result add(@RequestBody Category obj){
        categoryService.add(obj);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category obj = categoryService.getById(id);
        return Result.success(obj);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Category obj){
        categoryService.update(obj);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        categoryService.delete(id);
        return Result.success();
    }
}
