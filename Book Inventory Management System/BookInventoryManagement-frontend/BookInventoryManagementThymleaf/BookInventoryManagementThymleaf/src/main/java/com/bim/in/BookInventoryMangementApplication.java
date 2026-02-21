package com.bim.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bim")
@SpringBootApplication
public class BookInventoryMangementApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookInventoryMangementApplication.class, args);
    }

}

