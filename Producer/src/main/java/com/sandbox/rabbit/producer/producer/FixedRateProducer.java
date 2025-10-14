package com.sandbox.rabbit.producer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FixedRateProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 500) //milisekunde
    public void sendMessage(){
        i++;
//        log.info("i is: " + i);
        rabbitTemplate.convertAndSend("course.fixedrate", "Fixed rate : " + i);
    }

}
