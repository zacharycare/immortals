package com.zacharyz.userservice.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zacharyz.common.entity.Result;
import com.zacharyz.userentity.bean.User;
import com.zacharyz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProvider {

    @Autowired
    UserService userService;

    @GetMapping(value = "selectUsers")
    public List<User> selectUsers(){
        return userService.selectList(null);
    }

    /**
     * 验证用户登录名及密码
     * @param user 包含登录名及密码的User对象
     * @return 返回一个User
     */
    @PostMapping(value = "verifyUser")
    public Result verifyUser(@RequestBody User user){
        Map<String,Object> params = new HashMap<>();
        params.put("username",user.getUsername());
        params.put("password",user.getPassword());
        user = userService.selectOne(new EntityWrapper<User>().eq("username",user.getUsername()));
        if (user == null) {
            return new Result("1001","用户不存在",null);
        } else {
            user = userService.selectOne(new EntityWrapper<User>().allEq(params));
            if (user == null) {
                return new Result("1001","用户名密码错误",null);
            } else {
                return new Result("1","用户名密码校验成功",user);
            }
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "provider-addUser")
    public Result addUser(@RequestBody User user){
        User userdb = userService.selectOne(new EntityWrapper<User>().eq("username",user.getUsername()));
        if (userdb != null) {
            return new Result("1001","用户已存在",user);
        }
        System.out.println(user);
        boolean flag = false;
        try {
            flag = userService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag) {
            return new Result("1","添加成功",user);
        }
        return new Result("1001","操作失败",null);
    }
}
