package com.springboot.springbootmybatis.mapper;

import com.springboot.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2022-08-14
 * Time: 16:12
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> getUsers();
}
