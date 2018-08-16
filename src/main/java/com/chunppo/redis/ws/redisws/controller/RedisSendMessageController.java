package com.chunppo.redis.ws.redisws.controller;

import com.chunppo.redis.ws.redisws.queue.RedisCountMessagePublisher;
import com.chunppo.redis.ws.redisws.queue.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : redis-ws
 * @Date : 2018-08-10
 * @Author : chunppo
 * @Description :
 */
@RestController
public class RedisSendMessageController {
    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Autowired
    private RedisCountMessagePublisher redisCountMessagePublisher;

    @MessageMapping("/sendMessage")
    public void sendMessage(String message) throws Exception {
        redisMessagePublisher.publish(message);
    }

    @GetMapping("/http/sendMessage")
    public void httpSendMessage(@RequestParam String message) throws Exception {
        redisMessagePublisher.publish(message);
    }

    @GetMapping("/http/sendMessage/count")
    public void httpSendMessage() throws Exception {
        redisCountMessagePublisher.publish("sdfsdfsd");
    }
}
