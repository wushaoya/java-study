package com.service.impl;

import com.entity.Users;
import com.mapper.UserMapper;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @date 2021/8/26
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void addUser(Users users) {
        this.userMapper.insertUsers(users);
    }
}
