package com.sandbox.rabbit.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FixedRateConsumer {

    @RabbitListener(queues = "course.fixedrate")
    public void listen(String message){
        log.info("Consumed message: {}", message);
    }

}
