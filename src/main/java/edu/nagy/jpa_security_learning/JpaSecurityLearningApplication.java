package edu.nagy.jpa_security_learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JpaSecurityLearningApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(JpaSecurityLearningApplication.class, args);
        Thread.sleep(99999999999L);
    }

}
