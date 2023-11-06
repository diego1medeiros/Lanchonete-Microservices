package br.com.lanchonete.vendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lanchonete.vendas.client.ProdutoClient;
import br.com.lanchonete.vendas.dto.ClienteDto;
import br.com.lanchonete.vendas.dto.ListaItemVendaDto;
import br.com.lanchonete.vendas.dto.ListaVendaDto;
import br.com.lanchonete.vendas.dto.ProdutoDto;
import br.com.lanchonete.vendas.dto.VendaDto;
import br.com.lanchonete.vendas.model.ItemVenda;
import br.com.lanchonete.vendas.model.Venda;
import br.com.lanchonete.vendas.repository.ItemVendaRepository;
import br.com.lanchonete.vendas.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItemVendaRepository itemVendaRepository;

	@Autowired
	private ProdutoClient produtoClient;

	private List<ProdutoDto> listaDeProdutos;

	private List<ClienteDto> listaDeClientes;

	public void cadastrarVenda(VendaDto dto) {
		Venda venda = modelMapper.map(dto, Venda.class);
		vendaRepository.save(venda);
		List<ItemVenda> itensVenda = venda.getItensVenda();
		List<ProdutoDto> listaProdutos = listaDeProdutos;

		for (ItemVenda itemVenda : itensVenda) {
			itemVenda.setVenda(venda);
			itemVendaRepository.save(itemVenda);

			for (ProdutoDto produto : listaProdutos) {
				if (itemVenda.getProdutoId().equals(produto.getId())) {
					int quantidade = produto.getEstoque() - itemVenda.getQtde();
					produto.setEstoque(quantidade);
					produtoClient.atualizaEstoque(produto);
				}
			}
		}
	}

	public List<ListaVendaDto> listarVendas() {
		List<Venda> vendas = vendaRepository.findAll();
		return vendas.stream().map(venda -> modelMapper.map(venda, ListaVendaDto.class)).collect(Collectors.toList());
	}

	public List<ListaVendaDto> listaDeVendas() {
		List<ListaVendaDto> listaVendas = listarVendas();
		List<ClienteDto> listarClientes = listaDeClientes;
		for (ListaVendaDto vendaDto : listaVendas) {
			for (ClienteDto clienteDto : listarClientes) {
				if (vendaDto.getClienteId().equals(clienteDto.getId())) {
					vendaDto.getCliente().setNome(clienteDto.getNome());
					vendaDto.getCliente().setEndereco(clienteDto.getEndereco());
					vendaDto.getCliente().setTelefone(clienteDto.getTelefone());
				}
			}
		}
		return listaVendas;
	}

	public void removerVenda(Long id) {
		vendaRepository.deleteById(id);
		Venda venda = vendaRepository.getReferenceById(id);
		List<ItemVenda> ItensVenda = itemVendaRepository.findByVendaId(id);
		for (ItemVenda itemVenda : ItensVenda) {
			itemVenda.setVenda(venda);
			itemVendaRepository.delete(itemVenda);
		}
	}

	public List<ListaItemVendaDto> listaDeItens(Long id) {
		List<ItemVenda> itemVendas = itemVendaRepository.findByVendaId(id);
		return itemVendas.stream().map(itemVenda -> modelMapper.map(itemVenda, ListaItemVendaDto.class))
				.collect(Collectors.toList());
	}

	public List<ListaItemVendaDto> listaDeItemVenda() {
		List<ItemVenda> itemVendas = itemVendaRepository.findAll();
		return itemVendas.stream().map(itemVenda -> modelMapper.map(itemVenda, ListaItemVendaDto.class))
				.collect(Collectors.toList());
	}

	public List<ListaItemVendaDto> listarItens(long id) {
		List<ListaItemVendaDto> listaDeItens = listaDeItens(id);
		List<ListaVendaDto> listaVendas = listaDeVendas();
		List<ProdutoDto> listaProdutos = listaDeProdutos;
		for (ListaItemVendaDto itemVendaDto : listaDeItens) {
			for (ListaVendaDto vendaDto : listaVendas) {
				for (ProdutoDto produtoDto : listaProdutos) {
					if (itemVendaDto.getVenda().getId().equals(vendaDto.getId())
							&& itemVendaDto.getProdutoId().equals(produtoDto.getId())) {
						itemVendaDto.getVenda().setCliente(vendaDto.getCliente());
						itemVendaDto.setProduto(produtoDto);
					}
				}
			}
		}
		return listaDeItens;
	}

	public void listarDeProdutos(List<ProdutoDto> listaProdutoDto) {
		listaDeProdutos = listaProdutoDto;
	}

	public void listarDeClientes(List<ClienteDto> listaClienteDto) {
		listaDeClientes = listaClienteDto;
	}

}
