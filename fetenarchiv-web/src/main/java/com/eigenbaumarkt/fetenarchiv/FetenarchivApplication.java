package com.eigenbaumarkt.fetenarchiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class FetenarchivApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetenarchivApplication.class, args);
    }

}
