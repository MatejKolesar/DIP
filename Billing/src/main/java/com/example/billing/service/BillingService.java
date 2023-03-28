package com.example.billing.service;


import com.example.billing.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BillingService {
    @Value("${userManagementUri}")
    private String uri;

    private static String endpoint = "/users";

    private final RestTemplate restTemplate;

    public BillingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void startBilling() {
        List<User> users  = this.restTemplate.getForObject(uri + endpoint, List.class);
        users.forEach(user -> calculateBillingForUser(user));


    }

    private void calculateBillingForUser(User user) {
        user.getAccount();
    }

}
