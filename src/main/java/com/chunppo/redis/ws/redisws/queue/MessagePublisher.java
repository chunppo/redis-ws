package com.chunppo.redis.ws.redisws.queue;

/**
 * @Project : redis-ws
 * @Date : 2018-08-14
 * @Author : chunppo
 * @Description :
 */
public interface MessagePublisher {
    void publish(final String message);
}
