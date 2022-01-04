package cn.itcast.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: RibbonConfig
 * @Description:
 * @Date: Create in 3:32 PM 2022/1/4
 * @Created By: JinleWeng
 * @Modified By:
 */
@Configuration
public class RibbonConfig {
    /**
     * 将ribbon的负载均衡策略改为随机规则 方式一：这种是全局的，无论是调用user还是order 策略都会被改变
     * @return
     */
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }
}
