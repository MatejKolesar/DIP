package org.example.filemetadata.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.filemetadata.services.FileMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class FileMetadataReceiver {
    private static final Logger log = LogManager.getLogger(FileMetadataReceiver.class);


    private final FileMetadataService fileMetadataService;

    public FileMetadataReceiver(FileMetadataService fileMetadataService) {
        this.fileMetadataService = fileMetadataService;
    }


    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        System.out.println("Got here");

        var ret = fileMetadataService.sendUserUpdate(message);
        log.info(ret);

    }

}
