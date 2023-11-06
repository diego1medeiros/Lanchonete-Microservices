package br.com.lanchonete.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

	private Long id;
	private String nome;
	private String categoria;
	private double preco;
	private String codigoBarra;
	private String codigoProduto;
	private String descricao;
	private int estoque ;
	private String caminhoImagem;
	private Long fornecedorId ;
	


	
}
