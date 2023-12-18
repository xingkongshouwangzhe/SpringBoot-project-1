package com.example.major;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * MappeScan注解指定当前项目中的Mapper接口的路径位置，
 * 在项目启动的时候会自动加载所有的接口文件
 * @MapperScan("接口文件的路径")
 */
@MapperScan("com.example.major.Mapper")
public class SpringBootProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProject1Application.class, args);
    }

}
