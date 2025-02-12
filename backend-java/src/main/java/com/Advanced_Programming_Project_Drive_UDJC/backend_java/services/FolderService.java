package com.Advanced_Programming_Project_Drive_UDJC.backend_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FolderService {

    @Autowired
    private RestTemplate restTemplate;

    public String sendUserRootToFastApi(String  username) {
        String endpoint_folder = "http://localhost:5000/receive-user_root";  // URL del backend FastAPI

        String jsonString = "{\"username\": \"" + username + "\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonString, headers);

        ResponseEntity<String> response = restTemplate.exchange(endpoint_folder, HttpMethod.POST, request, String.class);

        return response.getBody();
    }

    public String eliminateUserRootToFastApi(String  username) {
        String endpoint_folder = "http://localhost:5000/delete-user_root";  // URL del backend FastAPI
        String jsonString = "{\"username\": \"" + username + "\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonString, headers);
        ResponseEntity<String> response = restTemplate.exchange(endpoint_folder, HttpMethod.POST, request, String.class);
        return response.getBody();
    }
}

