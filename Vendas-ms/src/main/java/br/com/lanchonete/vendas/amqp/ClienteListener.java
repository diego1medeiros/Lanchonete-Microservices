package br.com.lanchonete.vendas.amqp;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.vendas.dto.ClienteDto;
import br.com.lanchonete.vendas.service.VendaService;

@Component
public class ClienteListener {

	@Autowired
	private VendaService vendaService;

	@RabbitListener(queues = "cliente.detalhes-venda")
	public void receberListarDeClientes(List<ClienteDto> listaClienteDto) {
		System.out.println(listaClienteDto);
		vendaService.listarDeClientes(listaClienteDto);
	}
}