package com.example.finalproject.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Hall {

    // 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 2
    @NotEmpty(message = "You must put a name for the hall")
    private String name;
    // 3
    @NotNull (message = "You must specify the number of guests the hall can accommodate")
    private Integer numberOfGuest;
    // 4
    @NotNull(message = "You must specify the price of hall")
    private Integer price;





}// end

