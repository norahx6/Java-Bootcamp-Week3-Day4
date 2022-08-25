package com.example.finalproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Data @Entity

public class Customer implements UserDetails {

    // 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    // 2
    @NotEmpty(message ="You must enter your name" )
    private String name;
    // 3
    @NotNull(message = "You must enter your age")
    private Integer age;
    // 4
    @Email
    private String email;
    // 5
    @NotEmpty(message = "You must enter your phone number")
    private String phoneNumber;
    // 6
    @NotEmpty(message = "You must enter your username")
    @Column(unique = true)
    private String username;
    // 7
    @NotEmpty(message = "You must enter your password")
    private String password;

    // 8
    @Pattern(regexp = "(admin|user)")
    private String role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}// end
