package sb.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping(value="/authsec")
@RestController
public class AuthenticatedSecurityController {

    @GetMapping(value="/message")
    public String getMessage(){
        return "<h1>Welcome with secured authentication at : "+ new Date()+"</h1>";
    }

}