package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class CustomerController {

    private final CustomerService customerService;

    // 1 get all customer
    @GetMapping("/customer")
    public ResponseEntity<List> getCustomer(){
        List<Customer> customers = customerService.getCustomer();
        return ResponseEntity.status(200).body(customers);
    }

    // 2 add admins
    @PostMapping("/customer")
    public ResponseEntity<ApiResponse>addCustomer(@RequestBody @Valid Customer customer ){
        customerService.addCustomer(customer); ;
        return ResponseEntity.status(201).body(new ApiResponse("Customer has been added,thank you",201));
    }

    // 3 update admins
    @PutMapping("/customer/{id}")
    public ResponseEntity<ApiResponse>updateCustomer(@RequestBody @Valid Customer customer , @PathVariable Integer id){
        customerService.updateCustomer(customer,id);
        return ResponseEntity.status(201).body(new ApiResponse("Customer has been updated,thank you",201));
    }

    // 4 delete admin
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<ApiResponse>deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(201).body(new ApiResponse("Customer has been deleted,thank you",201));
    }

    // 5 find customer by id
    @GetMapping("/customer/id")
    public ResponseEntity getCustomerById(@RequestParam Integer id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.status(200).body(customer);
    }

    // 6 find customer by name
    @GetMapping("customer/name")
    public ResponseEntity<List<Customer>>getCustomerByName(@RequestParam String name){
        List<Customer>customers=customerService.getCustomerByName(name);
        return ResponseEntity.status(200).body(customers);
    }

    // 7 find customer by age
    @GetMapping("customer/age")
    public ResponseEntity<List<Customer>>getCustomerByAge(@RequestParam Integer age){
        List<Customer>customers=customerService.geyCustomerByAge(age);
        return ResponseEntity.status(200).body(customers);
    }

    // 8 find customer by username
    @GetMapping("/customer/username")
    public ResponseEntity getCustomerByUsername(@RequestParam String username){
        Optional<Customer> customer = customerService.getCustomerByUserName(username);
        return ResponseEntity.status(200).body(customer);
    }

    // 9 find customer by email
    @GetMapping("/customer/email")
    public ResponseEntity getCustomerByEmail(@RequestParam String email){
        Customer customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.status(200).body(customer);
    }

    // 10 find customer by phone number end with
    @GetMapping("/customer/phone")
    public ResponseEntity getCustomerByPhoneNumber(@RequestParam String phoneNumber){
        Customer customer = customerService.getCustomerByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(customer);
    }





}// end
