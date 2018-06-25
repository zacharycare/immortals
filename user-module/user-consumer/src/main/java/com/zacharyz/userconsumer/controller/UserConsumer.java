package com.zacharyz.userconsumer.controller;

import com.zacharyz.common.entity.Result;
import com.zacharyz.userconsumer.service.UserConsumerService;
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

    @Autowired
    UserConsumerService userConsumerService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping(value = "consumer-users")
    public List<User> feignUsers(){
        return userConsumerService.selectUsers();
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping(value = "feign-login")
    public Result feignLoginUser(@RequestBody User user){
        return userConsumerService.loginUser(user);
    }

    @PostMapping(value = "register")
    public Result registerUser(@RequestBody User user) {
        return restTemplate.postForObject("http://user-service/provider-addUser",user,Result.class);
    }
}
