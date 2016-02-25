package com.ricardovz.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the application, it is the initial point for all the configuration needed
 * to get the application running and configured
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.ricardovz.test")
public class Application {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

        log.info("The application is running...");

    }
}
