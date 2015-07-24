package com.usee.performance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.usee.performance")
public class PerformanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceApplication.class, args);
    }
}
