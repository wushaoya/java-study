package com.example.springdatajpa.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author wushaoya
 * @date 2023-06-21
 * Time: 15:57
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 姓名
     */
    @Column(name = "username")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
}
