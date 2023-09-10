package com.example.carparkdemo.service.token;

import com.example.carparkdemo.service.HR.IHRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @Autowired
    private IHRService HRService;

    public RefreshTokenService(RefreshTokenRepo refreshTokenRepo) {
        this.refreshTokenRepo = refreshTokenRepo;
    }

    public RefreshToken createRefreshToken(Long employeeId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setEmployee(HRService.getEmployeeById(employeeId));
        refreshToken.setExpiryDate(Instant.now().plusMillis(8640000));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshTokenRepo.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(token);
            System.out.println("Refresh token expired");
            return null;
        }
        return token;
    }

    public RefreshToken findByToken(String token) {
        return refreshTokenRepo.findByToken(token).
                orElseThrow(() -> new RuntimeException("Refresh Token is not in the database!"));
    }
}
