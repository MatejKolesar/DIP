/**
 * Service for load controller to execute the action for load testing
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */
package com.example.usermanagement.services;

import com.example.usermanagement.entities.BigObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ResourceIntensiveService {
    private static Logger logger = Logger.getLogger(ResourceIntensiveService.class.getName());
    private List<Object> bigList = new ArrayList<>();

    public void uselessFunctionForCPUUsage(int ms) {
        final int NUM_TESTS = 1000;
        long start = System.nanoTime();
        for (int i = 0; i < NUM_TESTS; i++) {
            spin(ms);
        }
        logger.log(Level.INFO, "Took " + (System.nanoTime() - start) / 1000000 +
                "ms (expected " + (NUM_TESTS * 500) + ")");
    }

    public void addElementsToList(int numberOfElements) {
        logger.log(Level.INFO, "List size is " + bigList.size());
        for (int i = 0; i < numberOfElements; i++) {
            bigList.add(new BigObject());
        }
        logger.log(Level.INFO, "List size is " + bigList.size());
    }

    public void deleteElementsToList() {
        bigList.clear();
        logger.log(Level.INFO, "List size is " + bigList.size());
    }

    private static void spin(int milliseconds) {
        long sleepTime = milliseconds * 1000000L;
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {
        }
    }

}
