package com.vs45tech.springboot.todoWebApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;
    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model){
   if(authenticationService.isAuthenticate(name, password)){
    model.put("name",name);
    model.put("password",password);
    return "welcome";
   }
   model.put("error", "Authentication Failed");
      return "login";
    }
}
