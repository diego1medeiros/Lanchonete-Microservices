package br.com.lanchonete.vendas.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaixaDto {

	private Long id;
	private String tipoMovimento;
	private Date data;
	private double valorTotal;
	private double valorCaixa;
	private String observacao;
	private Long funcionarioId;
}
