package com.sandbox.rabbit.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class FixedRateConsumer {

    @RabbitListener(queues = "course.fixedrate", concurrency = "3-7")
    public void listen(String message) throws InterruptedException{
        log.info("Thread {} consumed message: {}", Thread.currentThread().getName(), message);
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(2000));
    }

}
