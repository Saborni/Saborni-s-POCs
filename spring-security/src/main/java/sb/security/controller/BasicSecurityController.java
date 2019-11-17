package sb.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping(value="/basesec")
@RestController
public class BasicSecurityController {

    @GetMapping(value="/message")
    public String getMessage(){
        return "<h1>Welcome with simple authentication at : "+ new Date()+"</h1>";
    }
}
