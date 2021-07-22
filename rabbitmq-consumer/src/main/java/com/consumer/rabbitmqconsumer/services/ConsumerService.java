package com.consumer.rabbitmqconsumer.services;

import com.consumer.rabbitmqconsumer.config.MQConfig;
import com.consumer.rabbitmqconsumer.entities.MQMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerService {

    @RabbitListener(queues = MQConfig.PRODUCER_QUEUE)
    public void rabbitListener(MQMessage message){
        log.info("Message ID {} : Message {} : Message Date {}",
                message.getMessageId(),
                message.getMessage(),
                message.getMessageDate());
    }
}