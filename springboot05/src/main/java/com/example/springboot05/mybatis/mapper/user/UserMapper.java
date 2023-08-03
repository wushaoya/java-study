package com.example.springboot05.mybatis.mapper.user;

import com.example.springboot05.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 9:46
 */
@Mapper
public interface UserMapper {
    List<User> getList();
}
