//import org.mybatis.spring.annotation.MapperScan;
package com.yunduo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 是 @mapperScan 扫描 dao 层的mapper 文件 不是 @ComponentScan
 */
@MapperScan("com.yunduo.dao")
@SpringBootApplication()
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
