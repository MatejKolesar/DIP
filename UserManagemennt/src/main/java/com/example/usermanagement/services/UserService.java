/**
 * Service for user controller to execute the action for user
 * handles updating needed dependencies between users and files
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */

package com.example.usermanagement.services;

import com.example.usermanagement.entities.File;
import com.example.usermanagement.entities.User;
import com.example.usermanagement.repository.FileRepository;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.usermanagement.config.RabbitMQ.ROOTING_KEY;
import static com.example.usermanagement.config.RabbitMQ.topicExchangeName;


@Service
public class UserService implements IUserService{
    private static Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    private final RabbitTemplate rabbitTemplate;




    public UserService(UserRepository userRepository,
                       FileRepository fileRepository,
                       RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.fileRepository = fileRepository;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public List<User> getAllUsers() {
        logger.log(Level.INFO, "getting all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        logger.log(Level.INFO, "Creating user!");
        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID id, User user) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        // set other properties as needed
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }


    public void shareFileWithUser(String fileName, UUID userId) {
        File file = fileRepository.findById(fileName).get();
        User user = userRepository.findById(userId).get();
        user.getSharedFiles().add(file);
        userRepository.save(user);

        postNotification(user, file);
        logger.log(Level.INFO, "Shared files with user " + user.getName());
    }

    public void addFileToUser(UUID userId, Map<String, String> info) {
        File file = new File();
        file.setFileTID(UUID.randomUUID().toString());
        file.setAddInfo(info.get("addInfo"));
        file.setSize(info.get("size"));
        file.setName(info.get("name"));
        file.setOriginalName("originalFilename");



        User user = userRepository.findById(userId).get();
        file.setOwner(user);

        fileRepository.save(file);

        logger.log(Level.INFO, "Added file to user");
    }



    private void postNotification(User user, File file) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("user", String.valueOf(user));
        actionmap.put("files", String.valueOf(file));
        rabbitTemplate.convertAndSend(topicExchangeName, ROOTING_KEY, actionmap);


        System.out.println("Send message to queue!");
    }
}
