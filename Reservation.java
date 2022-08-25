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
public class Reservation {

    // 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    // 2
    @NotEmpty(message = "You must enter hall name")
    private String hallName;
    // 3
    @NotNull(message = "You must enter the number of your guest")
    private Integer numberOfGuste;
    // 4
    @NotEmpty(message = "You must enter your date so we can check if it available ")
    private String date;
    // 5
    @NotEmpty(message = "You must enter your phone number")
    private String phoneNumber;

}// end
