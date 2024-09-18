package com.blog.by.kotor.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.blog.by.kotor")
public class Starter {
    public static void main( String[] args ) {
        SpringApplication.run(Starter.class, args);
    }

}
