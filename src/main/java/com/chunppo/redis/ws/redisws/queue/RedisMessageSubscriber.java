package com.chunppo.redis.ws.redisws.queue;

import com.chunppo.redis.ws.redisws.model.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.core.MessageSendingOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Project : redis-ws
 * @Date : 2018-08-14
 * @Author : chunppo
 * @Description :
 */
@AllArgsConstructor
public class RedisMessageSubscriber implements MessageListener {
    private MessageSendingOperations<String> messagingTemplate;

    public static List<String> messageList = new ArrayList<>();

    public void onMessage(final Message message, final byte[] pattern) {
        messageList.add(message.toString());
        messagingTemplate.convertAndSend("/topic/subscribe", new ChatMessage(RedisMessageSubscriber.lastMessage().get()));
    }

    public static Optional<String> lastMessage() {
        if (messageList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(messageList.get(messageList.size() - 1));
    }
}
