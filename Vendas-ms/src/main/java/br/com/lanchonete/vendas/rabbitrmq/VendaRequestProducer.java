package br.com.lanchonete.vendas.rabbitrmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class VendaRequestProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void solicitarDados(){

    	rabbitTemplate.convertAndSend("", "cliente.request", "LISTAR");
    	rabbitTemplate.convertAndSend("", "produto.request", "LISTAR");
    	rabbitTemplate.convertAndSend("", "funcionario.request", "LISTAR");
    	//rabbitTemplate.convertAndSend("", "fornecedor.request", "LISTAR");

    }

}
