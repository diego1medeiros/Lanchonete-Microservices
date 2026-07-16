package br.com.lanchonete.cliente.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.cliente.service.ClienteService;

@Component
public class ClienteRequestConsumer {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteProducer producer;

    @RabbitListener(queues = "cliente.request")
    public void solicitarClientes(String mensagem) {

        producer.enviarClientes(service.listarClientes());
    }

}
