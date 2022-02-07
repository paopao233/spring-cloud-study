package cn.itcast.order;

import cn.itcast.feign.clients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = UserClient.class) // 1、 开启feign服务 不开启会提示找不到bean  2、这里的clients是统一api以后需要加的 扫描指定的包 也可以直接使用basePackages扫描整体的包
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * http 请求工具 创建restemplate 并注入bean容器
     * @return
     */
    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate(){
            return new RestTemplate();
    }
}