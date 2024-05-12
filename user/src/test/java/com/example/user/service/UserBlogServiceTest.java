package com.example.user.service;

import com.example.user.dto.request.SignUpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserBlogServiceTest {
    @Autowired
    private UserBlogService authService;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void 통신1(){
        SignUpRequest request = new SignUpRequest("1234", "buja@2.com");
        Map<String, Object> res= restTemplate
                .postForEntity(
                        "http://localhost:8080/api/v1/auth/signin"
                        ,request
                        , Map.class).getBody();
        System.out.println(res);
    }
    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJidWphQDIuY29tIiwiZXhwIjoxNzE1NTkxOTY5fQ.DRTm9sVieH9rZQYnJLMmL8ZD550tTAH8-w3COWSVYAFPeIYgP108XNQqrH0F14zX";

        String email = authService.parseToken(token);

        assertNotNull(email);
        System.out.println(email);
    }
}

//eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJidWphQDIuY29tIiwiZXhwIjoxNzE1NTkxMzEzfQ.0_3S7vxvYdbjWwoIAW7zFXTuLmdLAmPwOzCZqIgPw9IZmEEoxM4RSyQ6vZdwgvpM