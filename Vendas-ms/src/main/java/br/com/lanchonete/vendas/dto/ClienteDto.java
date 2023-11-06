package br.com.lanchonete.vendas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private EnderecoDto endereco;

}
