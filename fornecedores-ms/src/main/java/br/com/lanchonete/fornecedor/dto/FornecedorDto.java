package br.com.lanchonete.fornecedor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorDto {

	private Long id;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String email;
	private EnderecoDto endereco;
}
