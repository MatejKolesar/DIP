package com.example.filemanagement.config;


import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Value("${spring.minio.url}")
    private String minioUrl;


    @Bean
    @Qualifier("MinioClient")
    public MinioClient createMinioClient() {
        System.out.println("How about this url: " + minioUrl);
        return MinioClient.builder()
            .endpoint("minioUrl")
            .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
            .build();
    }
}
