package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 通过注解方式启动springboot项目
 * 启动器
 */
@SpringBootApplication
@ServletComponentScan //在springboot启动时会扫描@WebServlet，并将该类实例化
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
