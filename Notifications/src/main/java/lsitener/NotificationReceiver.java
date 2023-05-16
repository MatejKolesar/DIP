package lsitener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class NotificationReceiver {
    private static final Logger log = LogManager.getLogger(NotificationReceiver.class);

    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        // Here would be a send to user to notify about progress
    }

}
