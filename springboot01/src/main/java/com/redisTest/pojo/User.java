package com.redisTest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author wushaoya
 * @date 2022-07-30
 * Time: 10:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class User {
    private String name;
    private Integer age;
}
