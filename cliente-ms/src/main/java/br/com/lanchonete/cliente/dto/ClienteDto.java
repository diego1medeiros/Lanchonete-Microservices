package br.com.lanchonete.cliente.dto;

import br.com.lanchonete.cliente.model.Endereco;
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
	private Endereco endereco;

}
