package com.ilovesshan.wjhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WjhsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjhsApplication.class, args);
    }

}
