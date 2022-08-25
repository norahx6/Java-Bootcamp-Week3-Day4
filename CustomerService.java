package com.example.finalproject.Service;

import com.example.finalproject.Model.Customer;
import com.example.finalproject.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 1 get all customer
    public List<Customer> getCustomer(){

        return customerRepository.findAll();
    }

    // 2 add customer
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    // 3 update customer
    public void updateCustomer(Customer customer, Integer id) {
        Customer oldCustomer = customerRepository.getById(id);
        oldCustomer.setUsername(customer.getUsername());
        oldCustomer.setPassword(customer.getPassword());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(oldCustomer);
    }

    // 4 delete customer
    public void deleteCustomer(Integer id) {
        Customer myCustomer = customerRepository.getById(id);
        customerRepository.delete(myCustomer);
    }

    // 5 find customer by id
    public Customer getCustomerById(Integer id){

        return customerRepository.findCustomerById(id);
    }

    // 6 find customer by name
    public List<Customer>getCustomerByName(String name){

        return customerRepository.findCustomerByName(name);
    }

    // 7 find customer by age
    public List<Customer>geyCustomerByAge(Integer age){

        return customerRepository.findByAgeGreaterThanEqual(age);
    }

    // 8 find customer by username
    public Optional<Customer> getCustomerByUserName(String username){
        return customerRepository.findCustomerByUsername(username);
    }

    // 9 find customer by email
    public Customer getCustomerByEmail(String email){

        return customerRepository.findCustomerByEmail(email);
    }

    // 10 find customer by phone number
    public Customer getCustomerByPhoneNumber(String phoneNumber){
        return customerRepository.findCustomerByPhoneNumber(phoneNumber);
    }







}// end
