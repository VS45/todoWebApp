package com.vs45tech.springboot.todoWebApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database

   // InMemoryUserDetailsManager
   // InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
     
        UserDetails userDetails1=createUsers("vs45tech","dummy");
        UserDetails userDetails2=createUsers("jacob","bringfireh");
return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

private UserDetails createUsers(String username,String password){
    Function <String,String> passwordEncoder=input->passwordEncoder().encode(input);
    UserDetails userDetails=User.builder().passwordEncoder(passwordEncoder)
    .username(username)
    .password(password)
    .roles("USER","ADMIN")
    .build();
    return userDetails;
}

    @Bean
    public PasswordEncoder passwordEncoder(){
return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        
        return null;
    }
}
