package cn.itcast.feign.clients;


import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign的客户端配置 ： 远程接口调用服务
 */
@FeignClient("userservice") // 发送请求时 声明去找哪个服务
public interface UserClient {

    /**
     *  接口 注意这里的user变成统一api以后是放在feign-api模块下的
     * @param id
     * @return
     */

    @GetMapping("/user/{id}") //声明是get方法
    public User findById(@PathVariable("id") long id);
}
