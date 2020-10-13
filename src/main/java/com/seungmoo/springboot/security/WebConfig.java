package com.seungmoo.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 컨트롤러 대신 이걸로 써도 된다.
        // registry.addViewController("/hello").setViewName("hello");
    }
}
