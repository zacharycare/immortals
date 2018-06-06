package com.zacharyz.userservice.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zacharyz.userentity.bean.User;
import com.zacharyz.userservice.dao.UserDao;
import com.zacharyz.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
}
