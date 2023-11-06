package br.com.lanchonete.cliente.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lanchonete.cliente.dto.ClienteDto;
import br.com.lanchonete.cliente.dto.ListaClienteDto;
import br.com.lanchonete.cliente.model.Cliente;
import br.com.lanchonete.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public ClienteDto cadastrarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		repository.save(cliente);
		return modelMapper.map(cliente, ClienteDto.class);
	}

	public List<ListaClienteDto> listarClientes() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map(cliente -> modelMapper.map(cliente, ListaClienteDto.class))
				.collect(Collectors.toList());

	}

	public void excluirCliente(Long id) {
		repository.deleteById(id);
	}

	public ClienteDto atualizarCliente(ClienteDto dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setId(dto.getId());
		cliente = repository.save(cliente);
		return modelMapper.map(cliente, ClienteDto.class);

	}

}
