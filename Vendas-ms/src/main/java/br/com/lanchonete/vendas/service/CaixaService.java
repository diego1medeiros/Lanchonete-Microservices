package br.com.lanchonete.vendas.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lanchonete.vendas.dto.CaixaDto;
import br.com.lanchonete.vendas.dto.ListaCaixaDto;
import br.com.lanchonete.vendas.dto.ListaFuncionarioDto;
import br.com.lanchonete.vendas.model.Caixa;
import br.com.lanchonete.vendas.repository.CaixaRepository;
import br.com.lanchonete.vendas.repository.VendaRepository;

@Service
public class CaixaService {

	@Autowired
	private CaixaRepository caixaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VendaRepository vendaRepository;

	private List<ListaFuncionarioDto> listaDeFuncionarios;

	public List<ListaCaixaDto> MovimentacaoDoCaixa() {
		List<Caixa> caixas = caixaRepository.findAll();
		return caixas.stream().map(caixa -> modelMapper.map(caixa, ListaCaixaDto.class)).collect(Collectors.toList());
	}

	public void excluirPorId(Long id) {
		caixaRepository.deleteById(id);
	}

	public CaixaDto CadastrarMovimentacaoCaixa(CaixaDto caixaDto) {
		Caixa caixa = modelMapper.map(caixaDto, Caixa.class);
		caixaRepository.save(caixa);
		return modelMapper.map(caixa, CaixaDto.class);
	}

	public Double buscaValorTotalDoCaixaPeloData(LocalDateTime localDateTime) {
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		Double valorTotal = vendaRepository.sumValorTotalByData(date);
		return valorTotal;
	}

	public List<ListaCaixaDto> ListaDaMovimentacaoDoCaixa() {
		List<ListaCaixaDto> listaMovimentacaoDoCaixa = MovimentacaoDoCaixa();
		List<ListaFuncionarioDto> ListaDeFuncionarios = listaDeFuncionarios;
		for (ListaCaixaDto movimentacaoDoCaixa : listaMovimentacaoDoCaixa) {
			for (ListaFuncionarioDto funcionarios : ListaDeFuncionarios) {
				if (movimentacaoDoCaixa.getFuncionarioId().equals(funcionarios.getId())) {
					movimentacaoDoCaixa.getFuncionario().setNome(funcionarios.getNome());
				}
			}
		}
		return listaMovimentacaoDoCaixa;
	}

	public void listarDeFuncionarios(List<ListaFuncionarioDto> listaFuncionarioDto) {
		listaDeFuncionarios = listaFuncionarioDto;
	}

}
