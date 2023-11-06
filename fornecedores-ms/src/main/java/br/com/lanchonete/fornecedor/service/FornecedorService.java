package br.com.lanchonete.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lanchonete.fornecedor.dto.FornecedorDto;
import br.com.lanchonete.fornecedor.dto.ListaFornecedorDto;
import br.com.lanchonete.fornecedor.model.Fornecedor;
import br.com.lanchonete.fornecedor.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public FornecedorDto cadastrarFornecedor(FornecedorDto dto) {
		Fornecedor fornecedor = modelMapper.map(dto, Fornecedor.class);
		repository.save(fornecedor);
		return modelMapper.map(fornecedor, FornecedorDto.class);
	}

	public List<ListaFornecedorDto> listarFornecedores() {
		List<Fornecedor> fornecedores = repository.findAll();
		return fornecedores.stream().map(fornecedor -> modelMapper.map(fornecedor, ListaFornecedorDto.class))
				.collect(Collectors.toList());
	}

	public void excluirFornecedor(Long id) {
		repository.deleteById(id);
	}

	public FornecedorDto atualizarFornecedor(FornecedorDto dto) {
		Fornecedor fornecedor = modelMapper.map(dto, Fornecedor.class);
		fornecedor.setId(dto.getId());
		fornecedor = repository.save(fornecedor);
		return modelMapper.map(fornecedor, FornecedorDto.class);

	}

}
