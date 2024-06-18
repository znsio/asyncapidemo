package com.tmforum.asyncapidemo;

import com.tmforum.asyncapidemo.sender.SendRequestAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsyncapidemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncapidemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(@Autowired SendRequestAction publishMessageAction) {
        publishMessageAction.publishMessage();
        return args -> {
        };
    }
}
