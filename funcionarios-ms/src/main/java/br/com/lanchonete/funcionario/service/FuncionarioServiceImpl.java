package br.com.lanchonete.funcionario.service;

import java.util.List;

import br.com.lanchonete.funcionario.dto.FuncionarioDto;
import br.com.lanchonete.funcionario.dto.ListarFuncionarioDto;


public interface FuncionarioServiceImpl {
	
	public FuncionarioDto cadastrarFuncionario(FuncionarioDto dto);
	
	public List<ListarFuncionarioDto> listarFuncionarios();

	public void excluirFuncionario(Long id) ;

	public FuncionarioDto atualizarFuncionario(FuncionarioDto dto);
		
}
