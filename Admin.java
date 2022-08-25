package com.example.finalproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Admin {

    // 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 2
    @NotEmpty(message = "You must enter name")
    private String name;
    // 3
    @NotNull(message = "You must enter age")
    private Integer age;
    // 4
    private String phoneNumber;
    // 5
    @NotEmpty(message = "You must enter username ")
    @Column(unique = true)
    private String username;
    // 6
    @NotEmpty(message = " You must enter password")
    private String password;
    // 7
    private String role;



}// end
