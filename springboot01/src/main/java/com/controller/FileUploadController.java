package com.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/8/25
 */
@RestController // @Controller和@ResponseBody的结合体
public class FileUploadController {

    @RequestMapping("/fileUploadController")
    public Map<String, Object> filerUpload(MultipartFile filename){
        System.out.println(filename.getOriginalFilename());
        try {
            filename.transferTo(new File("D://" + filename.getOriginalFilename()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

    @RequestMapping("")
    public Map<String, Object> uploadFTP() throws Exception{
        // create CamelContext
        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                /**
                 file: 表示使用文件Component
                 from 表示从哪里获取数据，进行消费
                 to  表示将数据生产到哪里
                 */
                from("").to("");
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(10000);

        // stop the CamelContext
        context.stop();
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

}
