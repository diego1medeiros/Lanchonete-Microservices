package br.com.lanchonete.produtos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

	private Long id;
	private String nome;
	private String categoria;
	private double preco;
	private String codigoBarra;
	private String codigoProduto;
	private String descricao;
	private int estoque;
	private String caminhoImagem;
	private Long fornecedorId;

}