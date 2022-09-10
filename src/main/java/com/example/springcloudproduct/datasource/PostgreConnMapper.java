package com.example.springcloudproduct.datasource;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PostgreConnMapper {
    String value() default "";
}
