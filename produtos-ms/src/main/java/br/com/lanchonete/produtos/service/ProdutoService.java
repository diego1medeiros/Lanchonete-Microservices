package br.com.lanchonete.produtos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lanchonete.produtos.dto.ListaFornecedorDto;
import br.com.lanchonete.produtos.dto.ListaProdutoDto;
import br.com.lanchonete.produtos.dto.ProdutoDto;
import br.com.lanchonete.produtos.model.Produto;
import br.com.lanchonete.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	private List<ListaFornecedorDto> listaDeFornecedores;

	public ProdutoDto cadastrarProduto(ProdutoDto dto) {
		Produto produto = modelMapper.map(dto, Produto.class);
		repository.save(produto);
		return modelMapper.map(produto, ProdutoDto.class);
	}

	public List<ListaProdutoDto> listarProdutos() {
		List<Produto> produtos = repository.findAll();
		return produtos.stream().map(produto -> modelMapper.map(produto, ListaProdutoDto.class))
				.collect(Collectors.toList());
	}

	public void excluirProduto(Long id) {
		repository.deleteById(id);
	}

	public ProdutoDto atualizarProduto(ProdutoDto dto) {
		Produto produto = modelMapper.map(dto, Produto.class);
		produto.setId(dto.getId());
		produto = repository.save(produto);
		return modelMapper.map(produto, ProdutoDto.class);

	}

	public List<ListaProdutoDto> listarDeProdutos() {
		List<ListaProdutoDto> listaProdutos = listarProdutos();
		List<ListaFornecedorDto> listaFornecedoresListener = listaDeFornecedores;

		for (ListaProdutoDto produtoDto : listaProdutos) {
			for (ListaFornecedorDto fornecedorDto : listaFornecedoresListener) {
				if (produtoDto.getFornecedorId().equals(fornecedorDto.getId())) {
					produtoDto.getFornecedor().setRazaoSocial(fornecedorDto.getRazaoSocial());
				}
			}
		}
		return listaProdutos;
	}

	public void listarDeFornecedores(List<ListaFornecedorDto> listaFornecedorDto) {
		listaDeFornecedores = listaFornecedorDto;
	}
}
