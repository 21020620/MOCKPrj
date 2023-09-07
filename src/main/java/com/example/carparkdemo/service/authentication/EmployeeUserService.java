package com.example.carparkdemo.service.authentication;

import com.example.carparkdemo.entities.Employee;
import com.example.carparkdemo.service.HR.IHRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeUserService implements UserDetailsService {
    @Autowired
    private IHRService HRService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = HRService.getEmployeeByAccount(username);
        if (employee == null) {
            throw new UsernameNotFoundException("Could not find employee");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole()));
        return User.withUsername(employee.getAccount())
                .password(passwordEncoder().encode(employee.getPassword()))
                .authorities(authorities)
                .build();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
