package com.example.notifications;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationListener {

    @RabbitListener(queues = "notification.queue")
    public void receiveMessage(Map<String, String> message) {
        System.out.println("Received message: " + message.toString());


    }

}