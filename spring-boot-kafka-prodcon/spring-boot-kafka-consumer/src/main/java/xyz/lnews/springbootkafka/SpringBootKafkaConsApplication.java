package xyz.lnews.springbootkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringBootKafkaConsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaConsApplication.class, args);
    }

    @KafkaListener(topics = "lnewstopic")
    public void listen(String message) {
        System.out.println("Received Messasge : " + message);
    }
}
