package com.example.springcloudproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudProductdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProductdApplication.class, args);
        System.out.println(">>>>>>>>>>>>>> " + System.getProperty("profiles"));
    }

}
