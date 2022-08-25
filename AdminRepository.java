package com.example.finalproject.Repository;


import com.example.finalproject.Model.Admin;
import com.example.finalproject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    // 1 find Admin by id
    Admin findAdminById(Integer id);
    // 2 find Admin by name
    List<Admin> findAdminByName(String name);
    // 3 find Admin by age
    List <Admin> findByAgeGreaterThanEqual(Integer age);
    // 4 find Admin by age
    List<Admin> findAdminByAge(Integer age);
    // 5 find Admin by username
    Admin findAdminByUsername(String username);
    // 6 find Admin by phone number
    Admin findAdminByPhoneNumber(String phoneNumber);



}// end
