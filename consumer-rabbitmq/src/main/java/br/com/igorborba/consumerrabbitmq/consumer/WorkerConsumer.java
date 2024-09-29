package br.com.igorborba.consumerrabbitmq.consumer;

import br.com.igorborba.consumerrabbitmq.config.RabbitMQConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class WorkerConsumer {

    @RabbitListener(queues = RabbitMQConstants.WORKER_QUEUE)
    public void consumer(Message<String> message) throws JsonProcessingException {

        System.out.println("Received RabbitMQ: " + message.getPayload());
    }
}
