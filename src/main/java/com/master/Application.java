package com.master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ColorXJH
 * @version 1.0
 * @description 启动类
 * @date 2020/9/24 12:04
 */
@SpringBootApplication
//扫描所有的mybatis包接口，也可以在每一个接口上注解@Mapper,这样可以不用统一扫描，不过同意扫描方便些
@MapperScan(value = "com.master.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
