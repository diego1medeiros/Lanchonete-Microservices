package br.com.lanchonete.vendas.controller;

import java.net.URI;
import java.time.LocalDateTime;
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
import br.com.lanchonete.vendas.dto.CaixaDto;
import br.com.lanchonete.vendas.dto.ListaCaixaDto;
import br.com.lanchonete.vendas.service.CaixaService;

@RestController
@RequestMapping("/lanchonete")
public class CaixaController {

	@Autowired
	private CaixaService caixaService;

	@GetMapping("/caixa")
	public ResponseEntity<List<ListaCaixaDto>> listaDeMovimentacaoDaCaixa() {
		return ResponseEntity.ok(caixaService.ListaDaMovimentacaoDoCaixa());

	}

	@PostMapping("/caixa")
	public ResponseEntity<?> FecharMovimentacaoCaixa(@RequestBody CaixaDto caixaDto,
			UriComponentsBuilder uriComponentsBuilder) {
		CaixaDto caixa = caixaService.CadastrarMovimentacaoCaixa(caixaDto);
		URI uri = uriComponentsBuilder.path("/listarcaixa/{id}").buildAndExpand(caixa.getId()).toUri();
		return ResponseEntity.created(uri).body(caixa);
	}

	@DeleteMapping("/caixa/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		caixaService.excluirPorId(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/caixa/{localDateTime}")
	public ResponseEntity<Double> valorTotalDoCaixa(@PathVariable LocalDateTime localDateTime) {
		Double valorTotal = caixaService.buscaValorTotalDoCaixaPeloData(localDateTime);
		return ResponseEntity.ok(valorTotal);
	}

}
