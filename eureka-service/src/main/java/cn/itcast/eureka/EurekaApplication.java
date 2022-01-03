package cn.itcast.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname: EurekaApplication
 * @Description:
 * @Date: Create in 2:19 PM 2022/1/2
 * @Created By: JinleWeng
 * @Modified By:
 */
@EnableEurekaServer // 开启eureka
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);

    }
}
