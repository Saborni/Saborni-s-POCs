package sb.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping(value="/authsec")
@RestController
public class AuthenticatedSecurityController {

    @GetMapping(value="/admin")
    public String getMessageAdmin(){
        return "<h1>Welcome Admin with secured authentication " +
                "at : "+ new Date()+"</h1>";
    }

    @GetMapping(value="/user")
    public String getMessageUser(){
        return "<h1>Welcome User with secured authentication " +
                "at : "+ new Date()+"</h1>";
    }

    @GetMapping(value="/all")
    public String getMessage(){
        return "<h1>Welcome to all with unauthorized access " +
                "at : "+ new Date()+"</h1>";
    }

}