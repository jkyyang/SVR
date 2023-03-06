package com.example.svr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.svr.mapper")

public class SvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvrApplication.class, args);
    }

}
