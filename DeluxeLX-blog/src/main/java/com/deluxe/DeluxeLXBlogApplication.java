package com.deluxe;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.deluxe.mapper")
public class DeluxeLXBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeluxeLXBlogApplication.class,args);
        log.info("------------ 项目加载成功 ------------");
    }
}
