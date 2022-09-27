package avva.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class AvvaBootApplication {
    public static void main(String[] args) {

        SpringApplication.run(AvvaBootApplication.class, args);
    }
}
