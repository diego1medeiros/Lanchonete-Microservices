package br.com.lanchonete.funcionario.controller;

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

import br.com.lanchonete.funcionario.dto.FuncionarioDto;
import br.com.lanchonete.funcionario.dto.ListarFuncionarioDto;
import br.com.lanchonete.funcionario.service.FuncionarioService;

@RestController
@RequestMapping("/lanchonete")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping
	public ResponseEntity<List<ListarFuncionarioDto>> listarFuncionarios() {
		List<ListarFuncionarioDto> funcionarioDto = service.listarFuncionarios();
		rabbitTemplate.convertAndSend("funcionario.lista", "", funcionarioDto);
		return ResponseEntity.ok(service.listarFuncionarios());
	}

	@PostMapping
	public ResponseEntity<FuncionarioDto> cadastrarFuncionario(@RequestBody FuncionarioDto dto,
			UriComponentsBuilder uriComponentsBuilder) {
		FuncionarioDto funcionarioDto = service.cadastrarFuncionario(dto);
		URI uri = uriComponentsBuilder.path("/listarfuncionario/{id}").buildAndExpand(funcionarioDto.getId()).toUri();
		return ResponseEntity.created(uri).body(funcionarioDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FuncionarioDto> excluir(@PathVariable Long id) {
		service.excluirFuncionario(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<FuncionarioDto> atualizar(@RequestBody FuncionarioDto dto) {
		FuncionarioDto atualizado = service.atualizarFuncionario(dto);
		return ResponseEntity.ok(atualizado);
	}

}
