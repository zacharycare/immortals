package com.zacharyz.userservice.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zacharyz.userentity.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
