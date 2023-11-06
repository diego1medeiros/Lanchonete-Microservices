package br.com.lanchonete.cliente.controller;

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

import br.com.lanchonete.cliente.dto.ClienteDto;
import br.com.lanchonete.cliente.dto.ListaClienteDto;
import br.com.lanchonete.cliente.service.ClienteService;

@RestController
@RequestMapping("/lanchonete")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping
	public ResponseEntity<List<ListaClienteDto>> listarClientes() { 
		List<ListaClienteDto>  listaDeClientes = service.listarClientes();
		rabbitTemplate.convertAndSend("cliente.lista","", listaDeClientes );
		return ResponseEntity.ok(service.listarClientes());
	}

	@PostMapping
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		ClienteDto clienteDto = service.cadastrarCliente(dto);
		URI uri = uriComponentsBuilder.path("/listarcliente/{id}").buildAndExpand(clienteDto.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDto> excluir(@PathVariable Long id) {
		service.excluirCliente(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody ClienteDto dto) {
		ClienteDto atualizado = service.atualizarCliente(dto);
		return ResponseEntity.ok(atualizado);
	}
}
