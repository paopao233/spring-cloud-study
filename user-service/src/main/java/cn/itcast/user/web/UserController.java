package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope // 配置热更新 自动更新 方式一
public class UserController {

    @Autowired
    private UserService userService;
    // 这种方式找不到会启动不了
//    @Value("${pattern.dateformat}")
//    private String pattern;

    // 方式二 通过自动注入获取配置类的信息 就不需要加 @RefreshScope注解了 也会自动热更新
    @Autowired
    private PatternProperties properties;

    @RequestMapping(value = "now")
    public PatternProperties getTime(){
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
        return properties;
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth" ,required = false) String truth) {
        System.out.println(truth);
        return userService.queryById(id);
    }
}
