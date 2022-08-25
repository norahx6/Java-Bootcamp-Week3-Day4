package com.example.finalproject.Service;


import com.example.finalproject.Model.Customer;
import com.example.finalproject.Repository.AdminRepository;
import com.example.finalproject.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return customerRepository.findCustomerByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Wrong username or password ! "));
    }





}// end
