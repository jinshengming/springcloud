package net.htjs.pt4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.htjs.pt4.dao")
//@ServletComponentScan
//@EnableCaching
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5)
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

}
