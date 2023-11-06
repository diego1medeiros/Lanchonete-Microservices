package br.com.lanchonete.produtos.amqp;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.lanchonete.produtos.dto.ListaFornecedorDto;
import br.com.lanchonete.produtos.service.ProdutoService;

@Component
public class FornecedorListener {

	@Autowired
	private ProdutoService produtoService;

	@RabbitListener(queues = "fornecedores.detalhes-produto")
	public void receberListarDeFornecedores(List<ListaFornecedorDto> listaFornecedorDto) {

		System.out.println(listaFornecedorDto);
		produtoService.listarDeFornecedores(listaFornecedorDto);
	}
}