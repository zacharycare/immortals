package com.zacharyz.userservice.controller;

import com.zacharyz.userentity.bean.User;
import com.zacharyz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProvider {

    @Autowired
    UserService userService;

    @GetMapping(value = "selectUsers")
    public List<User> selectUsers(){
        return userService.selectList(null);
    }
}
