package org.example.filemetadata.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//public class FileMetadataListener {
//
//    @RabbitListener(queues = "file.queue")
//    public void receiveMessage(Object message) {
//        System.out.println("Received message: " + message.toString());
//    }
//
//}