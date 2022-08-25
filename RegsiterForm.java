package com.example.finalproject.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@AllArgsConstructor @Data
public class RegsiterForm  {

    // 1
    private String name;
    // 2
    private Integer age;
    // 3
    private String phoneNumber;
    // 4
    private String username;
    // 5
    private String password;
    // 6
    private String email;
    // 7
    private String role;


}// end

