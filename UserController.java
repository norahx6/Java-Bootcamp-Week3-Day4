package com.example.finalproject.Controller;


import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Dto.RegsiterForm;
import com.example.finalproject.Model.Admin;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Model.Hall;
import com.example.finalproject.Model.Reservation;
import com.example.finalproject.Repository.AdminRepository;
import com.example.finalproject.Repository.CustomerRepository;
import com.example.finalproject.Repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class UserController {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;


    @PostMapping("register")
    public ResponseEntity register(@RequestBody @Valid RegsiterForm regsiterForm){
        String hashedPassword= new BCryptPasswordEncoder().encode(regsiterForm.getPassword());
        regsiterForm.setPassword(hashedPassword);

        Customer customer = new Customer(null,regsiterForm.getName(),regsiterForm.getAge()
                ,regsiterForm.getEmail(),regsiterForm.getPhoneNumber(),regsiterForm.getUsername()
                ,regsiterForm.getPassword(),regsiterForm.getRole());

        Customer myCustomer=customerRepository.save(customer);

        if(regsiterForm.getRole().equals("admin")){
            Admin admin = new Admin(null,regsiterForm.getName(),regsiterForm.getAge()
                    ,regsiterForm.getPhoneNumber(),regsiterForm.getUsername()
                    ,regsiterForm.getPassword(),regsiterForm.getRole());
            adminRepository.save(admin);
            return ResponseEntity.status(201).body("New Admin registered!");
        }
        return ResponseEntity.status(201).body("New User registered!");




    }// end



}// end
