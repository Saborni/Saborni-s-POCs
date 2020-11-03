package xyz.lnews.springbootchaosmonkey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lnews.springbootchaosmonkey.service.VibgyorService;

import java.util.List;

@RestController
public class VibgyorController {
    @Autowired
    private VibgyorService service;

    @GetMapping("/getrainbow")
    public List<String> getRainbow(){
       return service.getRainbow();
    }
}
