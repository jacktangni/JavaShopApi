package com.httpapi.yyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.httpapi.yyy.dao")
@EnableSwagger2
public class YyyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyyApplication.class, args);
    }

}
