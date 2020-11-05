package com.huanletao.huanletao.controller;

import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.entity.WebCategory;
import com.huanletao.huanletao.service.api.CategoryService;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/28
 * @Time: 11:27
 * Description: 分类信息数据控制器。
 */@RestController
@RequestMapping("cate")
public class CategoryController {
     @Autowired
     private CategoryService categoryService;

     //查询所有数据信息。
    @GetMapping("findAll")
    public List<WebCategory> findAll(){
       return categoryService.findAll();
    }

    //保存修改或者添加的数据到数据库中
    @PostMapping("save")
    public ResponseObject save(@RequestBody WebCategory webCategory){
        categoryService.save(webCategory);
        return ResponseObject.success(ResponseEnum.SAVESUCCESS);
    }

    //删除分类信息
    @GetMapping("delete")
    public ResponseObject delete(int[] ids){
        categoryService.delete(ids);
        return ResponseObject.success(ResponseEnum.DELETESUCCESS);

    }
}
