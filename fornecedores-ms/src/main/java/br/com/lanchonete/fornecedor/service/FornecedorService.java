package br.com.lanchonete.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lanchonete.fornecedor.dto.FornecedorDto;
import br.com.lanchonete.fornecedor.dto.ListaFornecedorDto;
import br.com.lanchonete.fornecedor.model.Fornecedor;
import br.com.lanchonete.fornecedor.repository.FornecedorRepository;

@Service
public class FornecedorService implements FornecorServiceImpl {

	@Autowired
	private FornecedorRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	


	@Override
	public FornecedorDto cadastrarFornecedor(FornecedorDto dto) {
		Fornecedor fornecedor = modelMapper.map(dto, Fornecedor.class);
		repository.save(fornecedor);
		return modelMapper.map(fornecedor, FornecedorDto.class);
	}

	@Override
	public List<ListaFornecedorDto> listarFornecedores() {
		List<Fornecedor> fornecedores = repository.findAll();
		return fornecedores.stream().map(fornecedor -> modelMapper.map(fornecedor, ListaFornecedorDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void excluirFornecedor(Long id) {
		repository.deleteById(id);
	}

	@Override
	public FornecedorDto atualizarFornecedor(FornecedorDto dto) {
		Fornecedor fornecedor = modelMapper.map(dto, Fornecedor.class);
		fornecedor.setId(dto.getId());
		fornecedor = repository.save(fornecedor);
		return modelMapper.map(fornecedor, FornecedorDto.class);

	}
	
	

}
