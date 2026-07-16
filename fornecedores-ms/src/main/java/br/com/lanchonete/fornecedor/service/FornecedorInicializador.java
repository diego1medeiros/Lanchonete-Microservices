package br.com.lanchonete.fornecedor.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.lanchonete.fornecedor.dto.ListaFornecedorDto;

@Component
public class FornecedorInicializador {

	 @Autowired
	    private FornecedorService service;


	    @Autowired
	    private RabbitTemplate rabbitTemplate;



	    @EventListener(ApplicationReadyEvent.class)
	    public void enviarListaFornecedores() {


	        List<ListaFornecedorDto> lista =
	                service.listarFornecedores();


	        rabbitTemplate.convertAndSend(
	                "fornecedor.lista",
	                "",
	                lista
	        );


	        System.out.println(
	            "Lista de fornecedores enviada: "
	            + lista.size()
	        );
	    }

	}
