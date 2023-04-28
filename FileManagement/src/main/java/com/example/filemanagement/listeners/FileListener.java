package com.example.filemanagement.listeners;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;



/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class FileListener {




    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link guru.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
//        log.info("Received <" + message + ">");
//        Long id = Long.valueOf(message.get("id"));
//        Product product = productRepository.findById(id).orElse(null);
//        product.setMessageReceived(true);
//        product.setMessageCount(product.getMessageCount() + 1);
//
//        productRepository.save(product);
//        log.info("Message processed...");



    }
}