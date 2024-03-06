package com.nanchengyu.nanchengyubi.controller;

import com.nanchengyu.nanchengyubi.bizmq.BiMqMessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 * @date 2024/3/6
 * @description
 */
@RestController
public class BiController {
    @Resource
    BiMqMessageProducer biMqMessageProducer;

    @PostMapping("/bi")
    public void bi(@RequestParam String message) {
        biMqMessageProducer.sendMessage(message);
    }
}
