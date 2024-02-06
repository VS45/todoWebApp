package com.vs45tech.springboot.todoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {
    
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Welcome!";
    }
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHTML(){
        StringBuffer sb=new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Welcome to Spring Html</title>");
        sb.append("</head>");
        sb.append("<body><h1> First Web Page</h1></body>");
        sb.append("</html>");
        return sb.toString();
    }
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
   
}
