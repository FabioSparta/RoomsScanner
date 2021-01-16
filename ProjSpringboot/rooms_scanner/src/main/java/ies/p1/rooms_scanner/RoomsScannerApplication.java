package ies.p1.rooms_scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RoomsScannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomsScannerApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// Messaging -> https://spring.io/guides/gs/messaging-rabbitmq/
//Rpi code https://www.rabbitmq.com/tutorials/tutorial-five-python.html

//TODO:  https://www.vogella.com/tutorials/SpringBoot/article.html