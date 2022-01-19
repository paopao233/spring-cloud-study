package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName PatternProperties
 * Description 测试nacos属性热更新
 * Author lezi
 * Date 2022/1/19 16:21
 * Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    // 只需要找到配置前缀为 pattern就会自动搜索属性名为”dateformat“的配置信息
    private String dateformat;
    private String envShareValue;
}
