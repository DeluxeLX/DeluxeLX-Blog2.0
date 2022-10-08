package com.deluxe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许 Cookie
                .allowCredentials(true)
                // 设置允许跨域的方法
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许跨域的消息头
                .allowedHeaders("*")
                // 设置请求跨域的时间
                .maxAge(3600);
    }
}
