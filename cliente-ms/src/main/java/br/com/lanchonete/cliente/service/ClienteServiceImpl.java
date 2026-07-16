package br.com.lanchonete.cliente.service;

import java.util.List;

import br.com.lanchonete.cliente.dto.ClienteDto;
import br.com.lanchonete.cliente.dto.ListaClienteDto;

public interface ClienteServiceImpl {
	
	public ClienteDto cadastrarCliente(ClienteDto dto);
	
	public List<ListaClienteDto> listarClientes();
	
	public void excluirCliente(Long id);
	
	public ClienteDto atualizarCliente(ClienteDto dto); 
	

}
