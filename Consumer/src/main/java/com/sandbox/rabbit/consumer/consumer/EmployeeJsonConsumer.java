package com.sandbox.rabbit.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandbox.rabbit.consumer.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeJsonConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "course.employee")
    public void receiveMessage(String message) throws JsonProcessingException {
        var emp = objectMapper.readValue(message, Employee.class);
        log.info("Received Employee: {}", emp);
    }

}
