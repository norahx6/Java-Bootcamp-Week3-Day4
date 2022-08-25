package com.example.finalproject.Service;


import com.example.finalproject.Model.Admin;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    // 1 get all Admin
    public List<Admin> getAdmin(){
        return adminRepository.findAll();
    }

    // 2 add admin
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    // 3 update admin
    public void updateAdmin(Admin admin, Integer id) {
        Admin oldAdmin = adminRepository.getById(id);
        oldAdmin.setUsername(admin.getUsername());
        oldAdmin.setPassword(admin.getPassword());
        adminRepository.save(oldAdmin);
    }

    // 4 delete admin
    public void deleteAdmin(Integer id) {
        Admin myAdmin=adminRepository.getById(id);
        adminRepository.delete(myAdmin);
    }

    // 5 find admin by id
    public Admin getAdminById(Integer id){

        return adminRepository.findAdminById(id);
    }

    // 6 find admin by name
    public List<Admin> getAdminByName(String name){

        return adminRepository.findAdminByName(name);
    }

    // 7 find admin by age greater
    public List<Admin>getAdminByAge(Integer age){

        return adminRepository.findByAgeGreaterThanEqual(age);
    }

    // 8 find admin by age equal
    public List<Admin>getAdminByAgeEqual(Integer age){
        return  adminRepository.findAdminByAge(age);
    }

    // 8 find admin by username
    public Admin getAdminByUserName(String username){
        return adminRepository.findAdminByUsername(username);
    }


    // 10 find admin by phone number
    public Admin getAdminByPhoneNumber(String phoneNumber){
        return adminRepository.findAdminByPhoneNumber(phoneNumber);
    }

}// end
