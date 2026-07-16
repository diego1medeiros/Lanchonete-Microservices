package br.com.lanchonete.vendas.service;

import java.util.List;

import br.com.lanchonete.vendas.dto.ClienteDto;
import br.com.lanchonete.vendas.dto.ListaItemVendaDto;
import br.com.lanchonete.vendas.dto.ListaVendaDto;
import br.com.lanchonete.vendas.dto.ProdutoDto;
import br.com.lanchonete.vendas.dto.VendaDto;

public interface VendaServiceImpl {

	void cadastrarVenda(VendaDto dto);

	List<ListaVendaDto> listarVendas();

	List<ListaVendaDto> listaDeVendas();

	void removerVenda(Long id);

	List<ListaItemVendaDto> listaDeItemVenda();

	List<ListaItemVendaDto> listaDeItens(Long id);

	List<ListaItemVendaDto> listarItens(long id);

	void listarDeProdutos(List<ProdutoDto> listaProdutoDto);

	void listarDeClientes(List<ClienteDto> listaClienteDto);

}
