package br.com.lanchonete.vendas.amqp;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.vendas.dto.ProdutoDto;
import br.com.lanchonete.vendas.service.VendaService;

@Component
public class ProdutoListener {

	@Autowired
	private VendaService vendaService;

	@RabbitListener(queues = "produtos.detalhes-venda")
	public void receberListarDeProdutos(List<ProdutoDto> listaProdutoDto) {
		System.out.println(listaProdutoDto);
		vendaService.listarDeProdutos(listaProdutoDto);
	}
}