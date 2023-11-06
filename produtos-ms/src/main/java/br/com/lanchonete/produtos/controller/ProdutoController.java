package br.com.lanchonete.produtos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lanchonete.produtos.dto.ListaProdutoDto;
import br.com.lanchonete.produtos.dto.ProdutoDto;
import br.com.lanchonete.produtos.service.ProdutoService;

@RestController
@RequestMapping("/lanchonete")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping
	public ResponseEntity<List<ListaProdutoDto>> listarProdutos() {
		List<ListaProdutoDto> listaDeProdutos = service.listarDeProdutos();
		rabbitTemplate.convertAndSend("produto.lista","", listaDeProdutos);
		return ResponseEntity.ok(service.listarDeProdutos());
	}

	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody ProdutoDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		ProdutoDto produtoDto = service.cadastrarProduto(dto);
		URI uri = uriComponentsBuilder.path("/listarproduto/{id}").buildAndExpand(produtoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(produtoDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDto> excluir(@PathVariable Long id) {
		service.excluirProduto(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody ProdutoDto dto) {
		ProdutoDto atualizado = service.atualizarProduto(dto);
		return ResponseEntity.ok(atualizado);
	}

}
