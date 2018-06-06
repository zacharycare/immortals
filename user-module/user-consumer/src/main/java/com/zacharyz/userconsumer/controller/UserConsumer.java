package com.zacharyz.userconsumer.controller;

import com.zacharyz.userentity.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
