package br.com.igorborba.hrworker.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // instanciar classe ao iniciar a aplicacao
public class RabbitMQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    private static final String DIRECT_EXCHANGE = "amq.direct";

    private Queue queue (String name){ // Fila de mensagens:
        return new Queue(name, true, false, false);
    }

    private DirectExchange directExchange (){ // Exchange para rotear mensagens
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    private Binding relationship(Queue queue, DirectExchange exchange){ // Binding entre fila e exchange
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct // fazer request ao iniciar a aplicacao
    private void addQueue(){

        Queue queueWorker = this.queue(RabbitMQConstants.WORKER_QUEUE);

        DirectExchange directExchange = this.directExchange(); // direcionar mensagens na fila

        Binding relation = this.relationship(queueWorker, directExchange); // vincular fila e exchange

        this.amqpAdmin.declareQueue(queueWorker); // Atribuir filas no RabbitMQ

        this.amqpAdmin.declareExchange(directExchange); // Atribuir exchange

        this.amqpAdmin.declareBinding(relation); // vincular fila e exchange ao rabbitMQ
    }
}
