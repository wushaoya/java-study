package com.example.springdatajpa.test.dao;

import com.example.springdatajpa.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wushaoya
 * @date 2023-06-21
 * Time: 16:02
 */
public interface UserDao extends JpaRepository<User, Integer> {

}
