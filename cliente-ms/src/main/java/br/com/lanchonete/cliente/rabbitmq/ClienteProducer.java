package br.com.lanchonete.cliente.rabbitmq;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.cliente.dto.ListaClienteDto;

@Component
public class ClienteProducer {
	
	  @Autowired
	    private RabbitTemplate rabbitTemplate;

	    public void enviarClientes(List<ListaClienteDto> clientes) {

	        rabbitTemplate.convertAndSend(
	                "cliente.detalhes-venda",
	                "",
	                clientes
	        );
	    }
}
