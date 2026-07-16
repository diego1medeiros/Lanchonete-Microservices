package br.com.lanchonete.fornecedor.service;

import java.util.List;
import br.com.lanchonete.fornecedor.dto.FornecedorDto;
import br.com.lanchonete.fornecedor.dto.ListaFornecedorDto;

public interface FornecorServiceImpl {

	FornecedorDto cadastrarFornecedor(FornecedorDto dto);

	List<ListaFornecedorDto> listarFornecedores();

	void excluirFornecedor(Long id);

	FornecedorDto atualizarFornecedor(FornecedorDto dto);

}
