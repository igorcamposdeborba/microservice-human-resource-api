package br.com.igorborba.hrworker.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, Object message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }
}
