package com.itcast.gateway;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName AuthorizeFilter
 * Description gateway全局拦截器 这是一个示例 判断用户身份
 * Author lezi
 * Date 2022/1/24 17:18
 * Version 1.0
 **/
//@Order(-1) //优先级 越小越高
@Component
public class AuthorizeFilter implements GlobalFilter , Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1、获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();

        //获取参数
        String auth = params.getFirst("authorization");//查到第一个匹配的参数

        //3、判断参数值是否等于admin
        if ("admin".equals(auth)){
            //4、是，放行
            return chain.filter(exchange); // 调下一个过滤连 相当于放行了
        }

        //5、否，拦截此次请求
        //5.1、设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//未登录 401
        //5.2、拦截请求
        return exchange.getResponse().setComplete();
    }

    /**
     * 设置优先级  作用与注解@order一样
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
