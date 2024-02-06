package com.vs45tech.springboot.todoWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public boolean isAuthenticate(String username,String password){

boolean isValidUserName=username.equalsIgnoreCase("vs45tech");
boolean isValidPassword=password.equalsIgnoreCase("dummy");
        return isValidUserName && isValidPassword;
    }
}
