package com.chunppo.redis.ws.redisws.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Project : redis-ws
 * @Date : 2018-08-10
 * @Author : chunppo
 * @Description :
 */
@Data
@AllArgsConstructor
public class ChatMessage {
    private String content;
}
