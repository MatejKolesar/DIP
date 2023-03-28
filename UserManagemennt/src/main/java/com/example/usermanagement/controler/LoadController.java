/**
 * This controller defines the interface that is used during testing.
 * The provided operation either increase the CPU usage or memory usage
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */

package com.example.usermanagement.controler;


import com.example.usermanagement.services.ResourceIntensiveService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/load")
public class LoadController {

    private final ResourceIntensiveService resourceIntensiveService;

    public LoadController(ResourceIntensiveService resourceIntensiveService) {
        this.resourceIntensiveService = resourceIntensiveService;
    }

    @GetMapping("/memoryTest")
    public void getAllUsers() {
        resourceIntensiveService.addElementsToList(100);
    }

    @GetMapping("/CPUTest")
    public void getUserById() {
        resourceIntensiveService.uselessFunctionForCPUUsage(400);
    }

    @DeleteMapping ("/CPUTest")
    public void deleteList() {
        resourceIntensiveService.uselessFunctionForCPUUsage(400);
    }


}
