package com.sandbox.rabbit.producer;

import com.sandbox.rabbit.producer.entity.Employee;
import com.sandbox.rabbit.producer.entity.Picture;
import com.sandbox.rabbit.producer.producer.EmployeeJsonProducer;
import com.sandbox.rabbit.producer.producer.HumanResourceProducer;
import com.sandbox.rabbit.producer.producer.PictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {


    @Autowired
    private PictureProducer producer;

    private final List<String> SOURCES = List.of("mobile", "web");
    private final List<String> TYPES = List.of("jpg", "png", "svg");


    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i < 11; i++) {
            var picture = new Picture(
                    "Picture " + i,
                    TYPES.get(i % TYPES.size()),
                    SOURCES.get(i % SOURCES.size()),
                    ThreadLocalRandom.current().nextLong(1, 10000)
            );

            producer.sendMessage(picture);
        }
    }

}
