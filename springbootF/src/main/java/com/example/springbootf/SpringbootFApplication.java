package com.example.springbootf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringbootFApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFApplication.class, args);
        log.info("application started");
    }

}
