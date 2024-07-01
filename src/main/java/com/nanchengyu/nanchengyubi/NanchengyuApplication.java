package com.nanchengyu.nanchengyubi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主类（项目启动入口）
 * @author nanchengyu
 */
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.nanchengyu.nanchengyubi.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class NanchengyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanchengyuApplication.class, args);
    }

}