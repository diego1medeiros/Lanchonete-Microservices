package br.com.lanchonete.funcionario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String funcao;
	private Double salario;
	private String login;
	private String senha;
	private EnderecoDto endereco;
}
