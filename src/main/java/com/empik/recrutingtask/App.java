package com.empik.recrutingtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.empik")
@EnableConfigurationProperties
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
