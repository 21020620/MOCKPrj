package com.example.carparkdemo.controller;

import com.example.carparkdemo.entities.Employee;
import com.example.carparkdemo.service.HR.IHRService;
import com.example.carparkdemo.service.authentication.*;

import com.example.carparkdemo.service.token.JwtProvider;
import com.example.carparkdemo.service.token.RefreshToken;
import com.example.carparkdemo.service.token.RefreshTokenService;
import com.example.carparkdemo.service.token.TokenRefreshResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    IHRService HRService;
    @Autowired
    RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwt = jwtProvider.generateToken(HRService.getEmployeeByAccount(userDetails.getUsername()).getId());

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(HRService.getEmployeeByAccount(userDetails.getUsername()).getId());

        return new LoginResponse(jwt, refreshToken.getToken());
    }

    @PostMapping(value = "/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody String refreshRequest) {
        RefreshToken refreshToken = refreshTokenService.findByToken(refreshRequest);
        if(refreshToken == null)
            return ResponseEntity.badRequest().body("Invalid refresh token");
        if (refreshTokenService.verifyExpiration(refreshToken) == null) {
            return ResponseEntity.badRequest().body("Refresh token is expired!");
        }
        Employee employee = refreshToken.getEmployee();
        String token = jwtProvider.generateToken(employee.getId());
        return ResponseEntity.ok(new TokenRefreshResponse(token, refreshRequest));
    }
}

