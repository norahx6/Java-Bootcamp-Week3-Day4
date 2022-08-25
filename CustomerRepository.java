package com.example.finalproject.Repository;

import com.example.finalproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    // 1 find customer by id
    Customer findCustomerById(Integer id);
    // 2 find customer by name
    List<Customer>findCustomerByName(String name);
    // 3 find customer by age
    List<Customer>findByAgeGreaterThanEqual(Integer age);
    // 4 find customer by username
     Optional<Customer> findCustomerByUsername(String username);
    // 5 find customer by email
    Customer findCustomerByEmail(String email);

    // 6 find customer by phone number
    Customer findCustomerByPhoneNumber(String phoneNumber);





}// end
