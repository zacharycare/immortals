package com.zacharyz.userconsumer.controller;

import com.zacharyz.common.entity.Result;
import com.zacharyz.userentity.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserConsumer {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "consumer-users")
    public List<User> selectUser(){
        return restTemplate.getForEntity("http://user-service/selectUsers",List.class).getBody();
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    public Result loginUser(@RequestBody User user) {
        Result result = restTemplate.postForObject("http://user-service/verifyUser",user,Result.class);
        return result;
    }

    @PostMapping(value = "register")
    public Result registerUser(@RequestBody User user) {
        return restTemplate.postForObject("http://user-service/provider-addUser",user,Result.class);
    }
}
