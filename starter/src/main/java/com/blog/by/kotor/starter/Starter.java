package com.blog.by.kotor.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class Starter {

    static final Logger log = LoggerFactory.getLogger(Starter.class);

    public static void main( String[] args ) {
        log.info("Before Starting application");
        SpringApplication.run(Starter.class, args);
        log.debug("Starting my application in debug with {} args", args.length);
        log.info("Starting my application with {} args.", args.length);
    }

}
