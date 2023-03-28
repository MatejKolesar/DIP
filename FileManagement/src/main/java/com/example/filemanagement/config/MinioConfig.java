/**
 * This class defines the needed configuration for minIO
 *
 * @author  Matej Kolesar
 * @version 1.0
 * @since   13-05-2023
 */

package com.example.filemanagement.config;


import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${spring.minio.url}")
    private String minioUrl;

    @Value("${spring.minio.access-key}")
    private String accessKey;

    @Value("${spring.minio.secret-key}")
    private String secretKey;
    @Value("${spring.minio.bucket}")
    private String bucket;

    @Bean
    @Qualifier("MinioClient")
    public MinioClient createMinioClient() {


        MinioClient minioClient = MinioClient.builder()
            .endpoint(minioUrl)
            .credentials(accessKey, secretKey)
            .build();
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            } else {
                System.out.println("Bucket 'files' already exists.");
            }
        } catch (Exception e){
            throw new RuntimeException("Could not create bucket files!");
        }

        return minioClient;


    }
}
