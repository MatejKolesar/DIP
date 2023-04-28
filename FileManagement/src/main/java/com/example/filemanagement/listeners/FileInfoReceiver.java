package com.example.filemanagement.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FileInfoReceiver {
    private static final Logger log = LogManager.getLogger(FileInfoReceiver.class);

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");


        log.info("Message processed...{}", message.get("id"));
    }
}
