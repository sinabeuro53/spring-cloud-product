package com.example.springcloudproduct.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {        // WebMvcConfigurerAdapter  spring 2.0에서 넘어오면서 변경됨

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");

        // js/~라는 요청이 들어오면 /resources/js/~로 연결시켜준다.
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/templates/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/templates/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/templates/img/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}
