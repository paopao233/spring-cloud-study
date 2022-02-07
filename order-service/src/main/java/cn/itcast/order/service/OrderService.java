package cn.itcast.order.service;


import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    // 将feign客户端注入
    @Autowired
    private UserClient userClient;

    /**
     * 使用feign服务
     * @param orderId
     * @return
     */
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2. 利用feign发起http请求 获取用户的信息
        User user = userClient.findById(order.getUserId());
        order.setUser(user);

        // 4.返回
        return order;
    }

    /**
     * 使用restemplate的远程接口调用
     */
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//
//        // 2. 利用restemplate发起http请求 获取用户的信息
//        // 2.1 url路径
//        String url = "http://userservice:8081/user/" + order.getUserId(); //这里不能在直接写ip地址，要变更成eureka里面的服务名称
//
//        // 2.2 发送http请求 将返回的json结果反序列化为user对象 然后加到订单的详情中
//        User user = restTemplate.getForObject(url, User.class);
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }
}
