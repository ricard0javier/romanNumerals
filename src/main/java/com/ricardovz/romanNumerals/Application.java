package com.ricardovz.romanNumerals;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Main class of the application, it is the initial point for all the configuration needed
 * to get the application running and configured
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.ricardovz.romanNumerals")
public class Application {


    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    public ApplicationListener applicationListener() {

        return new ApplicationListener<EmbeddedServletContainerInitializedEvent>() {

            @Override
            public void onApplicationEvent(final EmbeddedServletContainerInitializedEvent event) {
                int port = event.getEmbeddedServletContainer().getPort();

                //http://www.askapache.com/online-tools/figlet-ascii/
                log.info("");
                log.info("______                            _   _                                _ ");
                log.info("| ___ \\                          | \\ | |                              | |");
                log.info("| |_/ /___  _ __ ___   __ _ _ __ |  \\| |_   _ _ __ ___   ___ _ __ __ _| |");
                log.info("|    // _ \\| '_ ` _ \\ / _` | '_ \\| . ` | | | | '_ ` _ \\ / _ \\ '__/ _` | |");
                log.info("| |\\ \\ (_) | | | | | | (_| | | | | |\\  | |_| | | | | | |  __/ | | (_| | |");
                log.info("\\_| \\_\\___/|_| |_| |_|\\__,_|_| |_\\_| \\_/\\__,_|_| |_| |_|\\___|_|  \\__,_|_|");
                log.info("");


                log.info("The application is running...");
                log.info("Try it -> http://localhost:{}/convertToRomanNumeral/3999", port);
            }
        };

    }
}
