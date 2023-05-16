package com.example.notifications.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class NotificationReceiver {
    private static final Logger log = LogManager.getLogger(NotificationReceiver.class);

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        // Here would be an email send to user to notify about progress
        // for our purpose this is fine and just some for loop will be used to simulate usage
        generateList();

    }

   private List<Integer> generateList() {
        return IntStream.range(0, 10000000).parallel().map(IntUnaryOperator.identity()).collect(ArrayList::new, List::add, List::addAll);
    }
}
