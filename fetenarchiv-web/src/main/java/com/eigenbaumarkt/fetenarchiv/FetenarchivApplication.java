package com.eigenbaumarkt.fetenarchiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FetenarchivApplication {

    public static void main(String[] args) {
        SpringApplication.run(FetenarchivApplication.class, args);
    }

}
