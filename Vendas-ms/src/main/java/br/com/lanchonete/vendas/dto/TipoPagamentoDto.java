package br.com.lanchonete.vendas.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPagamentoDto {

	private Long id;
	private String codigo;
	private String descricao;

}
