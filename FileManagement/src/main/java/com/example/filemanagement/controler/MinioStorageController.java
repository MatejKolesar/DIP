package com.example.filemanagement.controler;

import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/files")
public class MinioStorageController {


        @Autowired
        private MinioClient minioClient;

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

        @PostMapping
        public void addAttachment(@RequestParam("file") MultipartFile file) {
            try {
                boolean found =
                        minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
                if (!found) {
                    // Make a new bucket called 'asiatrip'.
                    minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
                } else {
                    System.out.println("Bucket 'asiatrip' already exists.");
                }

                minioClient.putObject(
                        PutObjectArgs.builder().bucket(bucket)
                                .object(file.getName())
                                .stream(file.getInputStream(), -1,5 * (1024)*1024)
                                .build()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

}
