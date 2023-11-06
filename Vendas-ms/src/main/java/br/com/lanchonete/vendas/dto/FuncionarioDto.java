package br.com.lanchonete.vendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDto  {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String funcao;
	private Double salario;
	private String login;
	private String senha;
	private EnderecoDto endereco ;
}