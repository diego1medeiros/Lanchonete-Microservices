package br.com.lanchonete.vendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lanchonete.vendas.dto.ListaItemVendaDto;
import br.com.lanchonete.vendas.dto.ListaVendaDto;
import br.com.lanchonete.vendas.dto.VendaDto;
import br.com.lanchonete.vendas.service.VendaService;

@RestController
@RequestMapping("/lanchonete")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping
	public void cadastrarVenda(@RequestBody VendaDto dto, UriComponentsBuilder uriComponentsBuilder) {
		vendaService.cadastrarVenda(dto);
	}

	@GetMapping
	public ResponseEntity<List<ListaVendaDto>> listarVendas() {
		return ResponseEntity.ok(vendaService.listaDeVendas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> imprimirPedido(@PathVariable Long id) {
		List<ListaItemVendaDto> ItensVenda = vendaService.listarItens(id);
		return ResponseEntity.ok(ItensVenda);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		vendaService.removerVenda(id);
		return ResponseEntity.noContent().build();
	}

}
