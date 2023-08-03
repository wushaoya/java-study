package com.example.springboot05.mybatis.mapper.blog;

import com.example.springboot05.mybatis.entity.QrtzLocks;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author wushaoya
 * @date 2023-06-09
 * Time: 9:51
 */
@Mapper
public interface QrtzLocksMapper {
    List<QrtzLocks> getQrtzLocks();
}
