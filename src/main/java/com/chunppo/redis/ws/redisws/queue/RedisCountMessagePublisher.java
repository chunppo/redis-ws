package com.chunppo.redis.ws.redisws.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

/**
 * @Project : redis-ws
 * @Date : 2018-08-14
 * @Author : chunppo
 * @Description :
 */
@Component
public class RedisCountMessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ChannelTopic countTopic;

    public RedisCountMessagePublisher() {
    }

    public RedisCountMessagePublisher(final RedisTemplate<String, Object> redisTemplate, final ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.countTopic = topic;
    }

    public void publish(final String message) {
        redisTemplate.convertAndSend(countTopic.getTopic(), message);
    }
}
