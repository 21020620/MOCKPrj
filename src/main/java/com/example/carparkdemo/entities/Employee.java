package com.example.carparkdemo.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name = "employee")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "account", nullable = false, unique = true)
    private String account;
    @Column (name = "department")
    private String department;
    @Column (name = "address")
    private String address;
    @Column (name = "birth_date")
    private Date birthDate;
    @Column (name = "email", unique = true)
    private String email;
    @Column (name = "name")
    private String name;
    @Column (name = "phone", unique = true)
    private String phone;
    @Column (name = "password", nullable = false)
    private String password;
    @Column (name = "sex")
    private String sex;

    private String role;

    public Employee(Long id, String account, String department, String address, Date birthDate,
                    String email, String name, String phone, String password, String sex, String role) {
        this.id = id;
        this.account = account;
        this.department = department;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.role = role;

    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
