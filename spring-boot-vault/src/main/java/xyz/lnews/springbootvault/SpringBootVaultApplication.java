package xyz.lnews.springbootvault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Credential.class)
public class SpringBootVaultApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SpringBootVaultApplication.class);

    private Credential credential;

    public SpringBootVaultApplication(Credential credential){
        this.credential = credential;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVaultApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("----------------------------------------");
        logger.info("Configuration properties fetched from Vault");
        logger.info("   lnews.username is {}", credential.getUserName());
        logger.info("   lnews.password is {}", credential.getPassword());
        logger.info("----------------------------------------");
    }
}
