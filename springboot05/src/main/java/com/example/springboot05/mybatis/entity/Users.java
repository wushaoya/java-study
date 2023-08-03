package com.example.springboot05.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 10:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Integer id;
    private String name;
    private Integer age;
}
