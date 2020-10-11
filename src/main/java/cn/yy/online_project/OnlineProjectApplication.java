package cn.yy.online_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("cn.yy.online_project.mapper")
@EnableTransactionManagement
public class OnlineProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineProjectApplication.class, args);
    }

}
