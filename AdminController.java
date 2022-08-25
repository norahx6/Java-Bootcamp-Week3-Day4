package com.example.finalproject.Controller;


import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Admin;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class AdminController {

    private final AdminService adminService;

    // 1 get all admin
    @GetMapping("/admin")
    public ResponseEntity<List> getAdmin(){
        List <Admin> admins = adminService.getAdmin();
        return ResponseEntity.status(200).body(admins);
    }

    // 2 add admins
    @PostMapping("/admin")
    public ResponseEntity<ApiResponse>addAdmin(@RequestBody @Valid Admin admin ){
       adminService.addAdmin(admin) ;
       return ResponseEntity.status(201).body(new ApiResponse("Admin has been added,thank you",201));
    }

    // 3 update admins
    @PutMapping("/admin/{id}")
    public ResponseEntity<ApiResponse>updateAdmin(@RequestBody @Valid Admin admin , @PathVariable Integer id){
        adminService.updateAdmin(admin,id);
        return ResponseEntity.status(201).body(new ApiResponse("Admin has been updated,thank you",201));
    }

    // 4 delete admin
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<ApiResponse>deleteAdmin(@PathVariable Integer id){
        adminService.deleteAdmin(id);
        return ResponseEntity.status(201).body(new ApiResponse("Admin has been deleted,thank you",201));

    }
    // 5 find admin by id
    @GetMapping("/admin/id")
    public ResponseEntity getAdminById(@RequestParam Integer id){
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.status(200).body(admin);
    }

    // 6 find admin by name
    @GetMapping("admin/name")
    public ResponseEntity<List<Admin>>getAdminByName(@RequestParam String name){
        List<Admin>admins=adminService.getAdminByName(name);
        return ResponseEntity.status(200).body(admins);
    }

    // 7 find admin by age greter than
    @GetMapping("/admin/age")
    public ResponseEntity<List<Admin>>getAdminByAgeGreater(@RequestParam Integer age){
        List<Admin>admins=adminService.getAdminByAge(age);
        return ResponseEntity.status(200).body(admins);
    }

    // 8 find admin by age greter than
    @GetMapping("/admin/ages")
    public ResponseEntity<List<Admin>>getAdminByAgeEqual(@RequestParam Integer age){
        List<Admin>admins=adminService.getAdminByAgeEqual(age);
        return ResponseEntity.status(200).body(admins);
    }

    // 9 find admin by username
    @GetMapping("/admin/username")
    public ResponseEntity getAdminByUsername(@RequestParam String username){
        Admin admin = adminService.getAdminByUserName(username);
        return ResponseEntity.status(200).body(admin);
    }

    // 10 find admin by phone number end with
    @GetMapping("/admin/phone")
    public ResponseEntity getAdminByPhoneNumber(@RequestParam String phoneNumber){
        Admin admin = adminService.getAdminByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(admin);
    }



}// end
