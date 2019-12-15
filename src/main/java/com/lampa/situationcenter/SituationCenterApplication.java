package com.lampa.situationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lampa.situationcenter.controllers",
        "com.lampa.situationcenter.services",
        "com.lampa.situationcenter.config"})
public class SituationCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SituationCenterApplication.class, args);
    }
}
