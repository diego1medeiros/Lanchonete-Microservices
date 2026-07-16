package br.com.lanchonete.funcionario.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.lanchonete.funcionario.dto.FuncionarioDto;
import br.com.lanchonete.funcionario.dto.ListarFuncionarioDto;
import br.com.lanchonete.funcionario.model.Funcionario;
import br.com.lanchonete.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService implements FuncionarioServiceImpl{

	@Autowired
	private FuncionarioRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public FuncionarioDto cadastrarFuncionario(FuncionarioDto dto) {
		Funcionario funcionario = modelMapper.map(dto, Funcionario.class);
		repository.save(funcionario);
		return modelMapper.map(funcionario, FuncionarioDto.class);
	}

	
	@Override
	public List<ListarFuncionarioDto> listarFuncionarios() {
		List<Funcionario> funcionarios = repository.findAll();
		return funcionarios.stream().map(funcionario -> modelMapper.map(funcionario, ListarFuncionarioDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void excluirFuncionario(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public FuncionarioDto atualizarFuncionario(FuncionarioDto dto) {
		Funcionario funcionario = modelMapper.map(dto, Funcionario.class);
		funcionario.setId(dto.getId());
		funcionario = repository.save(funcionario);
		return modelMapper.map(funcionario, FuncionarioDto.class);

	}

}
