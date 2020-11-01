package xyz.lnews.springbootcircuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getHelloWorld(){
        if(RandomUtils.nextBoolean())
            throw new RuntimeException("");
        return "Hello World!";
    }

    private String fallbackMethod(){
        return "fallback method called !";
    }

}
