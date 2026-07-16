package br.com.lanchonete.produtos.service;

import java.util.List;
import br.com.lanchonete.produtos.dto.ListaFornecedorDto;
import br.com.lanchonete.produtos.dto.ListaProdutoDto;
import br.com.lanchonete.produtos.dto.ProdutoDto;

public interface ProdutoServiceImpl {
	
	public ProdutoDto cadastrarProduto(ProdutoDto dto) ;
	

	public List<ListaProdutoDto> listarProdutos();
		

	public void excluirProduto(Long id);
	
	public ProdutoDto atualizarProduto(ProdutoDto dto) ;


	public List<ListaProdutoDto> listarDeProdutos();
		
	public void listarDeFornecedores(List<ListaFornecedorDto> listaFornecedorDto); 
	

}
