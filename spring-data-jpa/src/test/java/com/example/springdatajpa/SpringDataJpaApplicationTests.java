package com.example.springdatajpa;

import com.example.springdatajpa.test.dao.UserDao;
import com.example.springdatajpa.test.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        User user = new User();
        user.setUserName("Jack");
        user.setPassword("222222");
        userDao.save(user);
    }

}
