package br.com.lanchonete.produtos.model;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String nome;
	private String categoria;
	private double preco;
	@Column(name = "codigo_barra")
	private String codigoBarra;
	@Column(name = "codigo_produto")
	private String codigoProduto;
	private String descricao;
	@Column(name = "qtde_estoque")
	private int estoque ;
	@Column(name = "caminho_imagem")
	private String caminhoImagem;
	@Column(name = "id_fornecedor")
	private Long fornecedorId;

	
	
}
