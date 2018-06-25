package com.zacharyz.userentity.service;

import com.zacharyz.common.entity.Result;
import com.zacharyz.userentity.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("provider")
public interface UserServiceShare {

    @GetMapping(value = "select-user")
    List<User> selectUsers();

    @PostMapping(value = "add-user")
    Result addUser(User user);

    @PostMapping(value = "verify-user")
    Result verifyUser(User user);
}
