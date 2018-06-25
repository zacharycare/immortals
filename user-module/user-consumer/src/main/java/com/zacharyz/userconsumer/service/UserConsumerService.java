package com.zacharyz.userconsumer.service;

import com.zacharyz.userentity.service.UserServiceShare;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserConsumerService extends UserServiceShare {

}
