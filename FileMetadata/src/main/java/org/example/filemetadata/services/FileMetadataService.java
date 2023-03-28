package org.example.filemetadata.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Service
public class FileMetadataService {

    @Value("${userManagementUri}")
    private String uri;



    private final RestTemplate restTemplate;
    private static String endpoint = "/users/share";

    public FileMetadataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public boolean sendUserUpdate(Map<String, String> message) {

        var res = this.restTemplate.postForEntity(uri + endpoint + "/" + message.get("userId"), message, String.class);
        if(res.getStatusCode().is2xxSuccessful()) {
            return true;
        } else {
            return false;
        }
    }
}
