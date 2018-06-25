package com.zacharyz.userconsumer.service;

import com.zacharyz.common.entity.Result;
import com.zacharyz.userentity.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("user-service")
public interface UserConsumerService {

    @GetMapping(value = "provider-select-users")
    List<User> selectUsers();

    @PostMapping(value = "provider-verify-user")
    Result loginUser(User user);

    @PostMapping(value = "provider-add-user")
    Result registerUser(User user);
}
