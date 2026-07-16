package br.com.lanchonete.vendas.service;

import java.time.LocalDateTime;
import java.util.List;
import br.com.lanchonete.vendas.dto.CaixaDto;
import br.com.lanchonete.vendas.dto.ListaCaixaDto;
import br.com.lanchonete.vendas.dto.ListaFuncionarioDto;


public interface CaixaServiceImpl {
	
	
	public List<ListaCaixaDto> MovimentacaoDoCaixa(); 
	
	public void excluirPorId(Long id);
	

	public CaixaDto CadastrarMovimentacaoCaixa(CaixaDto caixaDto);
	

	public Double buscaValorTotalDoCaixaPeloData(LocalDateTime localDateTime);
		

	public List<ListaCaixaDto> ListaDaMovimentacaoDoCaixa();

	void listarDeFuncionarios(List<ListaFuncionarioDto> listaFuncionarioDto);
		
}
