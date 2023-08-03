package com.example.springboot05.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 9:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrtzLocks {
    private String schedName;
    private String lockName;
}
