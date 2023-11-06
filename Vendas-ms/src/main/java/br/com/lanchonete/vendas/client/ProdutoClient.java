package br.com.lanchonete.vendas.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.lanchonete.vendas.dto.ProdutoDto;

@FeignClient("produto")
public interface ProdutoClient {

	@GetMapping("/lanchonete")
	List<ProdutoDto> getProduto();
	
	@PostMapping("/lanchonete")
	void atualizaEstoque(@RequestBody ProdutoDto produto);

}
