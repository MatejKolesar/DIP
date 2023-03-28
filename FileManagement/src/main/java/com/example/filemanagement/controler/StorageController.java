/**
 * This class is the controller for operation with files
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */

package com.example.filemanagement.controler;

import io.minio.*;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.filemanagement.config.RabbitMQ.ROOTING_KEY;
import static com.example.filemanagement.config.RabbitMQ.topicExchangeName;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class StorageController {
    private final MinioClient minioClient;

    private final RabbitTemplate rabbitTemplate;

    private final String bucket = "files";


    @GetMapping("/{object}")
    public GetObjectResponse getObject(@PathVariable("object") String object) throws MinioException, IOException {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucket)
                            .object(object)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{userId}")
    public void updateExistingFile(@RequestParam("file") MultipartFile file, @PathVariable String userId) {
        try {
            var res = minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucket)
                            .object(file.getOriginalFilename())
                            .stream(file.getInputStream(), -1,5 * (1024)*1024)
                            .build()
            );

            postMetadataMessage(file.getName(), file.getSize(), file.getOriginalFilename(), userId, res.versionId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/{userId}")
    public void deleteFile(@RequestParam("file") MultipartFile file, @PathVariable String userId, @RequestBody String versionId) {
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder().bucket(bucket)
                            .object(file.getOriginalFilename())
                            .versionId(versionId)
                            .bypassGovernanceMode(true)
                            .build()
            );
            postMetadataMessage(file.getName(), file.getSize(), file.getOriginalFilename(), userId, versionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void postMetadataMessage(String name, long size, String originalFilename, String userId, String res) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("name", name);
        actionmap.put("size", String.valueOf(size));
        actionmap.put("originalFilename", originalFilename);
        actionmap.put("addInfo", "Some additional info");
        actionmap.put("userId", userId);
        actionmap.put("versionId", res);
        rabbitTemplate.convertAndSend(topicExchangeName, ROOTING_KEY, actionmap);


        System.out.println("Send message to queue!");
    }

}
