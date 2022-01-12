package com.ioco.technicalassesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TechnicalAssesmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechnicalAssesmentApplication.class, args);
    }

}
