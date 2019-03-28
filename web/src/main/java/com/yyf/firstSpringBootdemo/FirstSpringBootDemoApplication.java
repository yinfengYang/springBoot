package com.yyf.firstSpringBootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FirstSpringBootDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(FirstSpringBootDemoApplication.class, args);
    }

}
