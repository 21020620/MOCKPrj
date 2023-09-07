package com.example.carparkdemo.service.authentication;

import org.springframework.stereotype.Component;

@Component
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
