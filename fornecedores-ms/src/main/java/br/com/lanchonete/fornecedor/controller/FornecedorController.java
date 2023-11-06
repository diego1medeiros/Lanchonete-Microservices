package br.com.lanchonete.fornecedor.controller;

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
import br.com.lanchonete.fornecedor.dto.FornecedorDto;
import br.com.lanchonete.fornecedor.dto.ListaFornecedorDto;
import br.com.lanchonete.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/lanchonete")
public class FornecedorController {

	@Autowired
	private FornecedorService service;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping
	public ResponseEntity<List<ListaFornecedorDto>> listarFornecedores() {
		List<ListaFornecedorDto> listaDeFornecedores = service.listarFornecedores();
		rabbitTemplate.convertAndSend("fornecedor.lista", "", listaDeFornecedores);
		return ResponseEntity.ok(service.listarFornecedores());
	}

	@PostMapping
	public ResponseEntity<FornecedorDto> cadastrarFornecedor(@RequestBody FornecedorDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		FornecedorDto fornecedorDto = service.cadastrarFornecedor(dto);
		URI uri = uriComponentsBuilder.path("/listarfornecedor/{id}").buildAndExpand(fornecedorDto.getId()).toUri();
		return ResponseEntity.created(uri).body(fornecedorDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FornecedorDto> excluir(@PathVariable Long id) {
		service.excluirFornecedor(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody FornecedorDto dto) {
		FornecedorDto atualizado = service.atualizarFornecedor(dto);
		return ResponseEntity.ok(atualizado);
	}
}
