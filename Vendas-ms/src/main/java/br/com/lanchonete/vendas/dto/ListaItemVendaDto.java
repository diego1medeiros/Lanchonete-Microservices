package br.com.lanchonete.vendas.dto;


import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListaItemVendaDto {

	private Long id;
	private int qtde;
	private double valorTotal;
	private Long produtoId;
	private List<?> itensVenda;
	private ListaVendaDto venda;
	private ProdutoDto produto;
}
