package com.sandbox.rabbit.producer;

import com.sandbox.rabbit.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {


    @Autowired
    private HelloRabbitProducer helloRabbitProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
           helloRabbitProducer.sendHello("Name " + ThreadLocalRandom.current().nextInt());
    }

}
