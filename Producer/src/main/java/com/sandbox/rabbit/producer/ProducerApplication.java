package com.sandbox.rabbit.producer;

import com.sandbox.rabbit.producer.entity.Employee;
import com.sandbox.rabbit.producer.producer.EmployeeJsonProducer;
import com.sandbox.rabbit.producer.producer.HumanResourceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {


    @Autowired
    private HumanResourceProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 1; i < 4; i++) {
            var employee = new Employee("Emp-"+i, "Employee "+i, LocalDate.now());
            producer.sendMessage(employee);
        }
    }

}
